package com.psflickr.domain.flickr.repository

import com.psflickr.data.flickr.entity.Photo
import io.reactivex.Single

interface FlickrRepository {
    fun fetchRecentPhotos(extras: String): Single<List<Photo>>
}
