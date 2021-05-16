package com.psflickr.data.flickr.entity

import androidx.annotation.StringRes

data class ErrorOutput(
        @StringRes
        var message: Int,
        var rootException: Throwable? = null
)
