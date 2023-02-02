package com.example.feature_products

import com.example.common.BaseNavigator

interface ProductsNavigator : BaseNavigator {
    fun navigateToDetails(id: String)
}

const val navigationArgName = "id"