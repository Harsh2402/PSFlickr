package com.psflickr.data.flickr.respository

import com.psflickr.BuildConfig
import com.psflickr.data.flickr.entity.PhotoResponse
import io.reactivex.Single
import retrofit2.http.*

interface FlickrApi {
    @GET("services/rest/?method=flickr.photos.getRecent&nojsoncallback=1&format=json")
    fun fetchRecentPhotos(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("extras") extras: String
    ): Single<PhotoResponse>
}