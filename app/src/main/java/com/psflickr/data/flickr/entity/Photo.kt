package com.psflickr.data.flickr.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @Expose val farm: String,
    @Expose val server: String,
    @Expose val id: String,
    @Expose val secret: String,
    @Expose val title: String,
    @Expose val owner: String,
    @Expose val ispublic: Int,
    @Expose val isfriend: Int,
    @Expose val isfamily: Int
) : Parcelable

fun Photo.buildImageURL(): String {
    return "https://farm${farm}.staticflickr.com/${server}/${id}_${secret}.jpg"
}