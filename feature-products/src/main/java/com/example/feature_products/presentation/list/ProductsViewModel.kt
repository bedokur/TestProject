package com.example.feature_products.presentation.list

import androidx.lifecycle.viewModelScope
import com.example.common.baseviewmodel.BaseViewModel
import com.example.common.imageloader.ImageLoader
import com.example.common.resource.ResourceManager
import com.example.core_network.repository.models.ProductDomain
import com.example.feature_products.ProductsNavigator
import com.example.feature_products.R
import com.example.feature_products.data.ProductsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val navigator: ProductsNavigator,
    private val interactor: ProductsInteractor,
    private val resource: ResourceManager,
    imageLoader: ImageLoader
) : BaseViewModel(imageLoader) {

    private val _productsList = MutableSharedFlow<List<ProductDomain>>(replay = 1)
    val productsList = _productsList.asSharedFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = interactor.getProducts()
                .catch { _errorMessage.send(resource.getString(R.string.base_error_message)) }
            _productsList.emitAll(result)
        }
    }

    fun onProductClick(item: ProductDomain) {
        navigator.navigateToDetails(item.id.toString())
    }
}