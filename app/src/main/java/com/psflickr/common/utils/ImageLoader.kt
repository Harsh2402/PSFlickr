package com.psflickr.common.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.psflickr.R
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
object ImageLoader {

    private val imageViews: MutableMap<ImageView, String> =
        Collections.synchronizedMap(WeakHashMap<ImageView, String>())
    var executorService: ExecutorService = Executors.newFixedThreadPool(5)
    var stub_id: Int = R.drawable.ic_google

    fun displayImage(url: String, loader: Int = stub_id, imageView: ImageView) {
        imageViews[imageView] = url
        val bitmap: Bitmap? = MemoryCache[url]
        if (bitmap != null) imageView.setImageBitmap(bitmap) else {
            queuePhoto(url, imageView)
            imageView.setImageResource(loader)
        }
    }

    private fun queuePhoto(url: String, imageView: ImageView) {
        val p = PhotoToLoad(url, imageView)
        executorService.submit(PhotosLoader(p))
    }

    private fun getBitmap(url: String): Bitmap? {
        val f: File = FileCache.getFile(url)
        return decodeFile(f)
            ?: try {
                val imageUrl = URL(url)
                val conn: HttpURLConnection = imageUrl.openConnection() as HttpURLConnection
                conn.connectTimeout = 30000
                conn.readTimeout = 30000
                conn.instanceFollowRedirects = true
                val `is`: InputStream = conn.inputStream
                val os: OutputStream = FileOutputStream(f)
                Utils.copyStream(`is`, os)
                os.close()
                val bitmap: Bitmap? = decodeFile(f)
                bitmap
            } catch (ex: Exception) {
                ex.printStackTrace()
                null
            }
    }

    private fun decodeFile(f: File): Bitmap? {
        try {
            val o = BitmapFactory.Options()
            o.inJustDecodeBounds = true
            BitmapFactory.decodeStream(FileInputStream(f), null, o)

            val REQUIRED_SIZE = 90
            var width_tmp = o.outWidth
            var height_tmp = o.outHeight
            var scale = 1
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) break
                width_tmp /= 2
                height_tmp /= 2
                scale *= 2
            }
            val o2 = BitmapFactory.Options()
            o2.inSampleSize = scale
            return BitmapFactory.decodeStream(FileInputStream(f), null, o2)
        } catch (e: FileNotFoundException) {
        }
        return null
    }

    class PhotoToLoad(var url: String, i: ImageView) {
        var imageView: ImageView = i
    }

    internal class PhotosLoader(var photoToLoad: PhotoToLoad) : Runnable {
        override fun run() {
            if (imageViewReused(photoToLoad)) return
            val bmp: Bitmap? = getBitmap(photoToLoad.url)
            MemoryCache.put(photoToLoad.url, bmp)
            if (imageViewReused(photoToLoad)) return
            val bd = BitmapDisplayer(bmp, photoToLoad)
            val activity = photoToLoad.imageView.context as Activity
            activity.runOnUiThread(bd)
        }
    }

    fun imageViewReused(photoToLoad: PhotoToLoad): Boolean {
        val tag = imageViews[photoToLoad.imageView]
        return tag == null || tag != photoToLoad.url
    }

    internal class BitmapDisplayer(b: Bitmap?, p: PhotoToLoad) :
        Runnable {
        var bitmap: Bitmap? = b
        var photoToLoad: PhotoToLoad = p
        override fun run() {
            if (imageViewReused(photoToLoad)) return
            if (bitmap != null) photoToLoad.imageView.setImageBitmap(bitmap) else photoToLoad.imageView.setImageResource(
                stub_id
            )
        }
    }

    fun clearCache() {
        MemoryCache.clear()
        FileCache.clear()
    }
}