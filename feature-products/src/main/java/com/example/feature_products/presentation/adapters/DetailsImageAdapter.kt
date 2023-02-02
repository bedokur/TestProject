package com.example.feature_products.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.common.imageloader.ImageLoader
import com.example.feature_products.R
import com.example.feature_products.presentation.adapters.viewholders.DetailsImageViewHolder

class DetailsImageAdapter(
    private val imageLoader: ImageLoader
) : ListAdapter<String, DetailsImageViewHolder>(DetailsImagesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsImageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.details_image_list_item, parent, false)
        return DetailsImageViewHolder(itemView, imageLoader)
    }

    override fun onBindViewHolder(holder: DetailsImageViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class DetailsImagesDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}