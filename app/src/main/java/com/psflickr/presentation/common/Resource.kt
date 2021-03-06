package com.psflickr.presentation.common

data class Resource<out T> constructor(
    val status: Status,
    val data: T? = null,
    val throwable: Throwable? = null
)
