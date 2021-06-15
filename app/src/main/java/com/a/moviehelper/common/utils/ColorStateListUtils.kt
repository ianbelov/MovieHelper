package com.godeltech.pokedex.common.utils

import androidx.core.content.ContextCompat
import com.a.moviehelper.R
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.setDefaultIconTintStateList() =
    this.setStartIconTintList(
        ContextCompat.getColorStateList(context, R.color.selector_start_icon_tint_color)
    )

fun TextInputLayout.setErrorIconTintStateList() =
    this.setStartIconTintList(
        ContextCompat.getColorStateList(context, R.color.selector_start_icon_error_tint_color)
    )