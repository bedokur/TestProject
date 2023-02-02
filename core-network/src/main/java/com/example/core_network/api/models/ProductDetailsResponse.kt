package com.example.core_network.api.models

import com.example.core_network.repository.models.ProductDetailsDomain
import com.google.gson.annotations.SerializedName

data class ProductDetailsResponse(
    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("discountPercentage")
    val discountPercentage: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String
)

fun ProductDetailsResponse.mapToDomain(): ProductDetailsDomain {
    return ProductDetailsDomain(
        id = id,
        title = title,
        description = description,
        price = price.toString(),
        discount = discountPercentage.toInt().toString(),
        rating = rating.toString(),
        brand = brand,
        category = category,
        thumbnail = thumbnail,
        imagesList = images
    )
}