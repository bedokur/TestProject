package com.example.feature_products.data

import com.example.core_network.api.models.Product
import com.example.core_network.repository.ProductsRepository
import com.example.core_network.repository.models.ProductDetailsDomain
import com.example.core_network.repository.models.ProductDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ProductsInteractor {
    suspend fun getProducts(): Flow<List<ProductDomain>>
    suspend fun getDetails(id: String): Flow<ProductDetailsDomain>
}

class ProductsInteractorImpl @Inject constructor(
    private val repository: ProductsRepository
) : ProductsInteractor {

    override suspend fun getProducts(): Flow<List<ProductDomain>> {
        return repository.getProducts()
    }

    override suspend fun getDetails(id: String): Flow<ProductDetailsDomain> {
        return repository.getProductDetails(id)
    }
}
