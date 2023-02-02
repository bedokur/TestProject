package com.example.core_network.repository

import com.example.core_network.api.ProductsApi
import com.example.core_network.api.models.mapListToDomain
import com.example.core_network.api.models.mapToDomain
import com.example.core_network.repository.models.ProductDetailsDomain
import com.example.core_network.repository.models.ProductDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ProductsRepository {
    suspend fun getProducts(): Flow<List<ProductDomain>>
    suspend fun getProductDetails(id: String): Flow<ProductDetailsDomain>
}

class ProductsRepositoryImpl @Inject constructor(
    private val api: ProductsApi
) : ProductsRepository {

    override suspend fun getProducts(): Flow<List<ProductDomain>> {
        return flow {
            val response = api.getProducts()
            val result = if (response.isSuccessful) {
                checkNotNull(response.body()) { "Data cannot be null" }
            } else throw IllegalStateException(response.errorBody().toString())
            val domain = result.products.mapListToDomain()
            emit(domain)
        }
    }

    override suspend fun getProductDetails(id: String): Flow<ProductDetailsDomain> {
        return flow {
            val response = api.getProductDetails(id)
            val result = if (response.isSuccessful) {
                checkNotNull(response.body()) { "Data cannot be null" }
            } else throw IllegalStateException(response.errorBody().toString())
            val domain = result.mapToDomain()
            emit(domain)
        }
    }
}