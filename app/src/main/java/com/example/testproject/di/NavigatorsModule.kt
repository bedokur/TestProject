package com.example.testproject.di

import com.example.feature_products.ProductsNavigator
import com.example.testproject.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigatorsModule {

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = Navigator()

    @Provides
    @Singleton
    fun provideProductsNavigator(navigator: Navigator): ProductsNavigator = navigator
}