package com.psflickr.presentation.flickr.details

import androidx.lifecycle.ViewModelProviders
import com.psflickr.R
import com.psflickr.common.utils.ImageLoader
import com.psflickr.data.flickr.entity.Photo
import com.psflickr.data.flickr.entity.buildImageURL
import com.psflickr.presentation.common.base.BaseViewModel
import com.psflickr.presentation.common.base.BaseViewModelFragment
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.nav_header_with_icon.view.*

class FlickrDetailsFragment : BaseViewModelFragment<BaseViewModel>() {

    companion object {
        internal const val KEY_PHOTO = "photo"
    }

    override fun getContentResource(): Int = R.layout.fragment_details

    override fun injectDagger() {
        initPresenterComponent()?.inject(this)
    }

    override fun buildViewModel(): BaseViewModel {
        return ViewModelProviders.of(this, viewModelFactory)[BaseViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        header.btnBack.setOnClickListener(this)
        header.tvTitle.text = getString(R.string.flickr_details)
        arguments?.getParcelable<Photo>(KEY_PHOTO)?.let {
            setPhotoDetails(it)
        }
    }

    private fun setPhotoDetails(it: Photo) {
        ImageLoader.displayImage(it.buildImageURL(), imageView = ivPhoto)
        tvFarm.text = "Farm: " + it.farm
        tvServer.text = "Server: ${it.server}"
        tvId.text = "Id: ${it.id}"
        tvSecret.text = "Secret: ${it.secret}"
        tvPicTitle.text = "Title: ${it.title}"
        tvOwner.text = "Owner: ${it.owner}"
    }
}