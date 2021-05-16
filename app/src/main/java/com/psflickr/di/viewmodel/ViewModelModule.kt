package com.psflickr.di.viewmodel

import androidx.lifecycle.ViewModel
import com.psflickr.di.app.CommonModule
import com.psflickr.presentation.flickr.listing.RecentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

// to Inject ViewModel class
@Module(includes = [CommonModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecentViewModel::class)
    abstract fun bindRecentViewModel(viewModel: RecentViewModel): ViewModel
}
