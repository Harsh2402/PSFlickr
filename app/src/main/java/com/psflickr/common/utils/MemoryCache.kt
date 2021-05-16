package com.psflickr.common.utils

import android.graphics.Bitmap
import java.lang.ref.SoftReference
import java.util.*
import kotlin.collections.HashMap

object MemoryCache {
    private val cache: MutableMap<String, SoftReference<Bitmap>?> =
        Collections.synchronizedMap(HashMap<String, SoftReference<Bitmap>>() as Map<String, SoftReference<Bitmap>?>)

    operator fun get(id: String?): Bitmap? {
        if (!cache.containsKey(id)) return null
        val ref: SoftReference<Bitmap> = cache.get(id)!!
        return ref.get()
    }

    fun put(id: String, bitmap: Bitmap?) {
        cache[id] = SoftReference<Bitmap>(bitmap)
    }

    fun clear() {
        cache.clear()
    }
}