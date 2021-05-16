package com.a.moviehelper.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.a.moviehelper.databinding.ViewLoadingBinding

class ProgressIndicatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        ViewLoadingBinding.inflate(LayoutInflater.from(context), this)
    }
}