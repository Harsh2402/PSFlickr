package com.psflickr.di.presenter

import com.psflickr.di.app.AppComponent
import com.psflickr.di.viewmodel.ViewModelFactoryModule
import com.psflickr.di.viewmodel.ViewModelModule
import com.psflickr.presentation.FlickrActivity
import com.psflickr.presentation.flickr.details.FlickrDetailsFragment
import com.psflickr.presentation.flickr.listing.RecentFragment
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, ViewModelModule::class, ViewModelFactoryModule::class]
)
@PerPresenter
interface PresenterComponent {
    fun inject(presenter: FlickrActivity)

    fun inject(presenter: RecentFragment)
    fun inject(presenter: FlickrDetailsFragment)
}
