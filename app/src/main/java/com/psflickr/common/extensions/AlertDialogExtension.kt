package com.psflickr.common.extensions

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.psflickr.R

fun FragmentActivity.showAlertDialog(
    message: String,
    title: String = "",
    isNeedNegative: Boolean = true,
    positiveBtnText: Int = R.string.try_again,
    negativeBtnText: Int = R.string.cancel,
    cancellable: Boolean = false,
    positiveCallback: () -> Unit = {},
    negativeCallback: () -> Unit = {}
) {
    AlertDialog.Builder(this).create().apply {
        if (title.checkNotEmpty()) {
            setTitle(title)
        }
        setCancelable(cancellable)
        setMessage(message)
        setButton(
            AlertDialog.BUTTON_POSITIVE,
            this@showAlertDialog.resources.getString(positiveBtnText)
        ) { dialog, _ ->
            positiveCallback.invoke()
            dialog.dismiss()
        }
        if (isNeedNegative) {
            setButton(
                AlertDialog.BUTTON_NEGATIVE,
                this@showAlertDialog.resources.getString(negativeBtnText)
            ) { dialog, _ ->
                negativeCallback.invoke()
                dialog.dismiss()
            }
        }
        show()
    }
}