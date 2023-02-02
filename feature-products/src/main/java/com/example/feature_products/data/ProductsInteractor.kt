package com.example.feature_products.data

import com.example.core_network.di.IoDispatcher
import com.example.core_network.repository.ProductsRepository
import com.example.core_network.repository.models.ProductDetailsDomain
import com.example.core_network.repository.models.ProductDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ProductsInteractor {
    suspend fun getProducts(): Flow<List<ProductDomain>>
    suspend fun getDetails(id: String): Flow<ProductDetailsDomain>
}

class ProductsInteractorImpl @Inject constructor(
    private val repository: ProductsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ProductsInteractor {

    override suspend fun getProducts(): Flow<List<ProductDomain>> {
        return withContext(ioDispatcher) { repository.getProducts() }
    }

    override suspend fun getDetails(id: String): Flow<ProductDetailsDomain> {
        return withContext(ioDispatcher) { repository.getProductDetails(id) }
    }
}
