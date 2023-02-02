package com.example.common.baseviewmodel

import androidx.lifecycle.ViewModel
import com.example.common.imageloader.ImageLoader
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseViewModel(
    imageLoader: ImageLoader,
) : ViewModel(),
    ImageLoader by imageLoader {

    val _errorMessage = Channel<String>()
    val errorMessage = _errorMessage.receiveAsFlow()
}