package com.psflickr.presentation.flickr.listing

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.psflickr.BuildConfig
import com.psflickr.R
import com.psflickr.common.extensions.showAlertDialog
import com.psflickr.data.flickr.entity.Photo
import com.psflickr.presentation.common.Resource
import com.psflickr.presentation.common.Status
import com.psflickr.presentation.common.base.BaseViewModelFragment
import com.psflickr.presentation.common.base.SafeObserver
import com.psflickr.presentation.flickr.details.FlickrDetailsFragment
import kotlinx.android.synthetic.main.fragment_recent.*
import kotlinx.android.synthetic.main.nav_header_with_icon.view.*


class RecentFragment : BaseViewModelFragment<RecentViewModel>(),
    SwipeRefreshLayout.OnRefreshListener {

    companion object {
        private const val STORAGE_PERMISSION_CODE = 101
    }

    override fun getContentResource(): Int = R.layout.fragment_recent

    private val photoListAdapter by lazy {
        RecentPhotoListAdapter {
            val bundle = bundleOf(FlickrDetailsFragment.KEY_PHOTO to it)
            findNavController().navigate(R.id.actionFlickrListFragmentToDetailFragment, bundle)
        }
    }

    override fun injectDagger() {
        initPresenterComponent()?.inject(this)
    }

    override fun buildViewModel(): RecentViewModel {
        return ViewModelProviders.of(this, viewModelFactory)[RecentViewModel::class.java]
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.photoEvents.observe(viewLifecycleOwner, SafeObserver(this::handleFlickrResponse))
    }

    override fun initViews() {
        super.initViews()
        srlImages.setOnRefreshListener(this)
        header.btnBack.visibility = View.GONE
        header.tvTitle.text = getString(R.string.flickr_list)
        fetchFlickrData()
    }

    private fun fetchFlickrData() {
        if (checkPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_CODE
            )
        ) {
            viewModel.getFlickrPics()
        }
    }

    private fun handleFlickrResponse(response: Resource<List<Photo>>) {
        when (response.status) {
            Status.LOADING -> srlImages.isRefreshing = true
            Status.ERROR -> handleFlickrError(response)
            Status.SUCCESS -> handleFlickrSuccess(response.data)
        }
    }

    private fun handleFlickrError(response: Resource<List<Photo>>) {
        srlImages.isRefreshing = false
        response.throwable?.let {
            activity?.showAlertDialog(
                message = it.message ?: "",
                positiveCallback = {
                    onRefresh()
                },
                negativeCallback = {
                    activity?.onBackPressed()
                }
            )
        }
    }

    private fun handleFlickrSuccess(data: List<Photo>?) {
        srlImages.isRefreshing = false
        photoListAdapter.addAll(data as ArrayList<Photo>, true)
        rvImages.adapter = photoListAdapter
    }

    override fun onRefresh() {
        srlImages.isRefreshing = true
        viewModel.getFlickrPics()
    }

    // Function to check and request permission.
    private fun checkPermission(permission: String, requestCode: Int): Boolean {
        return if (ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            requestPermissions(
                arrayOf(permission),
                requestCode
            )
            false
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchFlickrData()
            } else {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    requireActivity().showAlertDialog(
                        message = "You need to allow the Storage permission to load data.",
                        positiveBtnText = R.string.go_to_app_info,
                        positiveCallback = {
                            startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                data = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                            })
                        },
                        negativeCallback = {
                            activity?.onBackPressed()
                        }
                    )
                } else {
                    requireActivity().showAlertDialog(
                        message = "Storage Permission Denied",
                        positiveBtnText = R.string.ask_permission,
                        isNeedNegative = false,
                        positiveCallback = {
                            fetchFlickrData()
                        }
                    )
                }
            }
        }
    }
}