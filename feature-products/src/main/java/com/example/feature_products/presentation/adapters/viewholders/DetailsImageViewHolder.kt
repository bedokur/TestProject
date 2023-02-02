package com.example.feature_products.presentation.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.common.imageloader.ImageLoader
import com.example.feature_products.databinding.DetailsImageListItemBinding

class DetailsImageViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding by viewBinding(DetailsImageListItemBinding::bind)

    fun onBind(url: String) {
        imageLoader.loadImage(viewBinding.image, url)
    }
}