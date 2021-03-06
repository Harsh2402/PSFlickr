package com.psflickr.common.extensions

import androidx.lifecycle.MutableLiveData
import com.psflickr.presentation.common.Resource
import com.psflickr.presentation.common.Status

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T){
    postValue(
        Resource(
            Status.SUCCESS,
            data
        )
    )
}

fun <T> MutableLiveData<Resource<T>>.setLoading() = postValue(Resource(Status.LOADING))

fun <T> MutableLiveData<Resource<T>>.setSuccess() = postValue(Resource(Status.SUCCESS))

fun <T> MutableLiveData<Resource<T>>.setError(throwable: Throwable? = null) {
    postValue(
        Resource(
            Status.ERROR,
            throwable = throwable
        )
    )
}

fun <T> MutableLiveData<Resource<T>>.setError(data: T) {
    postValue(
        Resource(
            Status.ERROR,
            data
        )
    )
}