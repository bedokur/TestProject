package com.example.core_network.di

import com.example.core_network.repository.ProductsRepository
import com.example.core_network.repository.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@InstallIn(ViewModelComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun bindProductsRepository(repositoryImpl: ProductsRepositoryImpl): ProductsRepository
}