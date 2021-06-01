package com.a.moviehelper.ui.feature.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

const val DETAILS_INPUT_MODEL_KEY = "details_input_model_key"

sealed class DetailsInputModel : Parcelable {

    @Parcelize
    data class Movie(val id: String) : DetailsInputModel()

    @Parcelize
    data class Show(val id: String) : DetailsInputModel()

    @Parcelize
    data class Person(val id: String) : DetailsInputModel()
}

