package com.example.feature_products.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.common.imageloader.ImageLoader
import com.example.core_network.repository.models.ProductDomain
import com.example.feature_products.R
import com.example.feature_products.presentation.adapters.viewholders.ProductsViewHolder

class ProductsAdapter(
    private val imageLoader: ImageLoader,
    private val onProductClick: (ProductDomain) -> Unit,
) : ListAdapter<ProductDomain, ProductsViewHolder>(ProductsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.products_list_item, parent, false)

        return ProductsViewHolder(itemView, imageLoader, onProductClick)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class ProductsDiffUtil() : DiffUtil.ItemCallback<ProductDomain>() {
    override fun areItemsTheSame(oldItem: ProductDomain, newItem: ProductDomain): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProductDomain, newItem: ProductDomain): Boolean {
        return oldItem.id == newItem.id
    }

}