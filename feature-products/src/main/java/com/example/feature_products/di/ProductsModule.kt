package com.example.feature_products.di

import com.example.feature_products.data.ProductsInteractor
import com.example.feature_products.data.ProductsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
interface ProductsModule {

    @Binds
    @ViewModelScoped
    fun bindProductsInteractor(interactorImpl: ProductsInteractorImpl): ProductsInteractor
}