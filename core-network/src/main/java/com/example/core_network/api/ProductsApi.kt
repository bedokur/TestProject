package com.example.core_network.api

import com.example.core_network.api.models.ProductDetailsResponse
import com.example.core_network.api.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: String): Response<ProductDetailsResponse>
}