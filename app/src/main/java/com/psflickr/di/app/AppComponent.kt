package com.psflickr.di.app

import com.psflickr.di.app.repository.FLickrModule
import com.psflickr.domain.flickr.repository.FlickrRepository
import com.psflickr.presentation.app.AppController
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [AppModule::class, NetworkModule::class, FLickrModule::class, CommonModule::class]
)
@Singleton
interface AppComponent {
    fun inject(app: AppController)
    fun flickrRepository(): FlickrRepository
}