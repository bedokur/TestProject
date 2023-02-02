package com.example.testproject

import androidx.annotation.NavigationRes
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.feature_products.ProductsNavigator
import com.example.feature_products.navigationArgName
import javax.inject.Inject

class Navigator @Inject constructor() : ProductsNavigator {

    var navController: NavController? = null
        private set

    override fun navigateToDetails(id: String) {
        val args = bundleOf(navigationArgName to id)
        navController?.navigate(R.id.action_listFragment_to_detailsFragment, args)
    }

    override fun popBack() {
        navController?.popBackStack()
    }

    fun setNavController(navController: NavController, @NavigationRes graph: Int) {
        navController.setGraph(graph)
        this.navController = navController
    }

    fun detachNavController() {
        navController = null
    }
}
