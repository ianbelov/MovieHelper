package com.a.moviehelper.common.imageloading

import android.widget.ImageView
import coil.load
import javax.inject.Inject

class CoilImageLoader @Inject constructor() : IImageLoader {

    override fun load(url: String, view: ImageView) {
        view.load(url)
    }

}