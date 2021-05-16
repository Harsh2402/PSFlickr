package com.psflickr.data.flickr.entity

import com.google.gson.annotations.Expose

data class PhotoWrapperOutput(
        @Expose val page: Int,
        @Expose val pages: Int,
        @Expose val total: Int,
        @Expose val photo: List<PhotoOutput>
)