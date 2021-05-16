package com.psflickr.presentation.flickr.listing

import com.psflickr.common.extensions.setError
import com.psflickr.common.extensions.setSuccess
import com.psflickr.data.flickr.entity.Photo
import com.psflickr.domain.flickr.repository.FlickrRepository
import com.psflickr.presentation.common.Resource
import com.psflickr.presentation.common.base.BaseViewModel
import com.psflickr.presentation.common.base.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecentViewModel @Inject constructor(
    private val flickrRepository: FlickrRepository
) : BaseViewModel() {

    internal val photoEvents = SingleLiveEvent<Resource<List<Photo>>>()

    fun getFlickrPics() {
        flickrRepository.fetchRecentPhotos("date_taken").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                photoEvents.setSuccess(it)
            }, {
                photoEvents.setError(it)
            }).collect()
    }
}