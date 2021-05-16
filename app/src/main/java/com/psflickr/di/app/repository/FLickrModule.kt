package com.psflickr.di.app.repository

import com.psflickr.data.flickr.respository.FlickrApi
import com.psflickr.data.flickr.respository.FlickrRepositoryImpl
import com.psflickr.domain.flickr.repository.FlickrRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class FLickrModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): FlickrApi {
        return retrofit.create(FlickrApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: FlickrApi
    ): FlickrRepository {
        return FlickrRepositoryImpl(
            api
        )
    }
}