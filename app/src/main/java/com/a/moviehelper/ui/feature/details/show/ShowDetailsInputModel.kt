package com.a.moviehelper.ui.feature.details.show

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

const val SHOW_DETAILS_INPUT_MODEL = "show_details_input_model"

@Parcelize
data class ShowDetailsInputModel(val id: String) : Parcelable