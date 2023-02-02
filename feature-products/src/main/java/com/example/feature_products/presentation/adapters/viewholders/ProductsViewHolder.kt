package com.example.feature_products.presentation.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.common.imageloader.ImageLoader
import com.example.core_network.repository.models.ProductDomain
import com.example.feature_products.databinding.ProductsListItemBinding

class ProductsViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader,
    private val onProductClick: (ProductDomain) -> Unit,
) : RecyclerView.ViewHolder(itemView) {
    private val viewBinding by viewBinding(ProductsListItemBinding::bind)

    fun onBind(item: ProductDomain) {
        with(viewBinding) {
            root.setOnClickListener { onProductClick(item) }
            imageLoader.loadImage(image, item.thumbnail)
            title.text = item.title
        }
    }
}