package com.psflickr.presentation

import com.psflickr.R
import com.psflickr.presentation.common.base.BaseActivity

class FlickrActivity : BaseActivity() {

    override fun getContentResource(): Int = R.layout.activity_flickr

    override fun injectDagger() {
        initScreenComponent()?.inject(this)
    }
}
