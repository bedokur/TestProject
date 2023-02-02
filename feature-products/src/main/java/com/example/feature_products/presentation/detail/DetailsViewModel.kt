package com.example.feature_products.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common.baseviewmodel.BaseViewModel
import com.example.common.imageloader.ImageLoader
import com.example.common.resource.ResourceManager
import com.example.core_network.repository.models.ProductDetailsDomain
import com.example.feature_products.ProductsNavigator
import com.example.feature_products.R
import com.example.feature_products.data.ProductsInteractor
import com.example.feature_products.navigationArgName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    imageLoader: ImageLoader,
    private val interactor: ProductsInteractor,
    private val savedStateHandle: SavedStateHandle,
    private val navigator: ProductsNavigator,
    private val resource: ResourceManager
) : BaseViewModel(imageLoader) {

    private val _productDetails = MutableSharedFlow<ProductDetailsDomain>(replay = 1)
    val productDetails = _productDetails.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<String>(navigationArgName)
            if (id == null) {
                _errorMessage.send(resource.getString(R.string.base_error_message))
            } else {
                val result = interactor.getDetails(id)
                    .catch { _errorMessage.send(resource.getString(R.string.base_error_message)) }
                _productDetails.emitAll(result)
            }
        }
    }

    fun navigateBack() {
        navigator.popBack()
    }
}