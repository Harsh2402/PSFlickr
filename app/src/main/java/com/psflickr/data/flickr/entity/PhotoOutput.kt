package com.psflickr.data.flickr.entity

import com.google.gson.annotations.Expose

data class PhotoOutput(
    @Expose val farm: String,
    @Expose val server: String,
    @Expose val id: String,
    @Expose val secret: String,
    @Expose val title: String,
    @Expose val owner: String,
    @Expose val ispublic: Int,
    @Expose val isfriend: Int,
    @Expose val isfamily: Int
)