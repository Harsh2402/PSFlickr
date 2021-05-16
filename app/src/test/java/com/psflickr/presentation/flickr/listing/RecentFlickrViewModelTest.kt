package com.psflickr.presentation.flickr.listing

import com.nhaarman.mockitokotlin2.*
import com.psflickr.data.flickr.entity.toPhoto
import com.psflickr.domain.flickr.repository.FlickrRepository
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mock

class RecentFlickrViewModelTest {

    @Mock
    private val flickrRepository = mock<FlickrRepository>()

    @Test
    fun testAPI() {
        whenever(
            flickrRepository.fetchRecentPhotos("date_taken")
        ).thenReturn(
            Single.just(photoResponse().photos.toPhoto())
        )
    }
}