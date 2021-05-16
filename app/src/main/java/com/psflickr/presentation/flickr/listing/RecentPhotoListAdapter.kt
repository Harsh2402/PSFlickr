package com.psflickr.presentation.flickr.listing

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.psflickr.R
import com.psflickr.common.utils.ImageLoader
import com.psflickr.data.flickr.entity.Photo
import com.psflickr.data.flickr.entity.buildImageURL
import com.psflickr.presentation.common.base.BaseRecyclerViewAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_recent.*

class RecentPhotoListAdapter(
    private val onItemClick: ((photo: Photo) -> Unit)
) :
    BaseRecyclerViewAdapter<Photo, RecentPhotoListAdapter.AddressListAdapterViewHolder>() {

    override fun createItemViewHolder(parent: ViewGroup): AddressListAdapterViewHolder {
        return AddressListAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_recent, parent, false)
        )
    }

    inner class AddressListAdapterViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        @SuppressLint("SetTextI18n")
        fun bind(photo: Photo, position: Int) {
            with(photo) {
                ImageLoader.displayImage(buildImageURL(), imageView = ivPhoto)
            }
            containerView.setOnClickListener {
                onItemClick.invoke(photo)
            }
        }
    }

    override fun bindItemViewHolder(holder: AddressListAdapterViewHolder, position: Int) {
        holder.bind(items[position], position)
    }
}