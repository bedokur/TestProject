package com.example.common.imageloader

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

interface ImageLoader {
    fun loadImage(targetView: ImageView, url: String)
}

class ImageLoaderImpl @Inject constructor(
    private val glide: RequestManager
) : ImageLoader {

    override fun loadImage(targetView: ImageView, url: String) {
        glide.load(url).into(targetView)
    }
}