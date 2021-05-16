package com.psflickr.presentation.common.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.psflickr.R

abstract class BaseViewModelFragment<T : BaseViewModel> : BaseFragment(), View.OnClickListener {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): T

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initLiveDataObservers()
        viewModel.loadPage(isMultipleLoad())
    }

    @CallSuper
    protected open fun initLiveDataObservers() {
    }

    protected open fun isMultipleLoad(): Boolean = false

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnBack -> activity?.onBackPressed()
        }
    }
}
