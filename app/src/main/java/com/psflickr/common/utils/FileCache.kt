package com.psflickr.common.utils

import android.os.Environment
import com.psflickr.presentation.app.AppController
import java.io.File

object FileCache {

    private var cacheDir: File? = null

    fun getFile(url: String): File {
        val filename = url.hashCode().toString()
        return File(cacheDir, filename)
    }

    fun clear() {
        val files: Array<File> = cacheDir?.listFiles() ?: return
        for (f in files) f.delete()
    }

    init {
        cacheDir = if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            File(Environment.getExternalStorageDirectory(), "TempImages")
        } else AppController.instance.cacheDir
        if (cacheDir?.exists() != true) cacheDir?.mkdirs()
    }
}
