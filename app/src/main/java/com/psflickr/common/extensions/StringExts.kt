package com.psflickr.common.extensions

import androidx.core.util.PatternsCompat

fun String.append(target: String): String {
    return StringBuilder(this).append(target).toString()
}

fun String?.checkNotEmpty(): Boolean {
    return this != null && isNotEmpty() && isNotBlank()
}

fun String?.isValidEmail(): Boolean {
    return if (checkNotEmpty()) {
        this?.let {
            return PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
        }
        false
    } else {
        false
    }
}

fun String?.isValidPassword(): Boolean {
    return if (checkNotEmpty()) {
        this?.let {
            return isMinLength(this)
        }
        false
    } else {
        false
    }
}

private fun isMinLength(field: String): Boolean {
    val isValid = field.checkNotEmpty()
    return if (!isValid) {
        false
    } else {
        return field.length >= 6
    }
}


fun String?.isRequiredField(): Boolean {
    return this != null && isNotEmpty() && isNotBlank()
}