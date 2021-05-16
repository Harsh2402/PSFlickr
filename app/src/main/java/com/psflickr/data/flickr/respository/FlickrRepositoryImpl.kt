package com.psflickr.data.flickr.respository

import com.psflickr.domain.flickr.repository.FlickrRepository
import com.psflickr.data.flickr.entity.Photo
import com.psflickr.data.flickr.entity.toPhoto
import io.reactivex.Single
import javax.inject.Inject

class FlickrRepositoryImpl @Inject constructor(
    private val flickrApi: FlickrApi
) : FlickrRepository {
    override fun fetchRecentPhotos(extras: String): Single<List<Photo>> {
        return flickrApi
            .fetchRecentPhotos(extras = extras)
            .map {
                it.photos.toPhoto()
            }
    }
}