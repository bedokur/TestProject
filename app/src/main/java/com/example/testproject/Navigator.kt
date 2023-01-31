package com.example.testproject

import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import javax.inject.Inject

class Navigator @Inject constructor() {

    var navController: NavController? = null
        private set

    fun setNavController(navController: NavController, @NavigationRes graph: Int) {
        navController.setGraph(graph)
        this.navController = navController
    }

}