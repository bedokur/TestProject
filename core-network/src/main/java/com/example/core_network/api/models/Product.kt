package com.example.core_network.api.models

import com.example.core_network.repository.models.ProductDomain
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)

fun List<Product>.mapListToDomain(): List<ProductDomain> {
    return map { it.mapToDomain() }
}

fun Product.mapToDomain() = ProductDomain(id, title, thumbnail)

