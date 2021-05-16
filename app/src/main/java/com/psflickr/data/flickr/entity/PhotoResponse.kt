package com.psflickr.data.flickr.entity

import com.google.gson.annotations.Expose

data class PhotoResponse(
    @Expose
    val photos: PhotoWrapperOutput
)