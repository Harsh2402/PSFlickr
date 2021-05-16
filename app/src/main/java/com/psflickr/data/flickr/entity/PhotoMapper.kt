package com.psflickr.data.flickr.entity

fun PhotoWrapperOutput.toPhoto(): List<Photo> {
    return this.photo.map {
        with(it) {
            Photo(
                farm,
                server,
                id,
                secret,
                title,
                owner,
                ispublic,
                isfriend,
                isfamily
            )
        }
    }
}