package com.example.testproject.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.common.imageloader.ImageLoader
import com.example.common.imageloader.ImageLoaderImpl
import com.example.common.resource.ResourceManager
import com.example.common.resource.ResourceManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [AppModule.Bind::class])
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGlideLoader(@ApplicationContext context: Context): RequestManager {
        return Glide.with(context)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface Bind {
        @Binds
        fun bindImageLoader(imageLoaderImpl: ImageLoaderImpl): ImageLoader

        @Binds
        fun bindResourceManager(resourceManagerImpl: ResourceManagerImpl): ResourceManager
    }
}