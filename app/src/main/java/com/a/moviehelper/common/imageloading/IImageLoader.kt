package com.a.moviehelper.common.imageloading

import android.widget.ImageView

interface IImageLoader {
    fun load(url: String, view: ImageView)
}