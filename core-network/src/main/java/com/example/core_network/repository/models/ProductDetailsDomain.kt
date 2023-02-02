package com.example.core_network.repository.models

import android.media.Rating

data class ProductDetailsDomain(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val discount: String,
    val rating: String,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val imagesList: List<String>
)
