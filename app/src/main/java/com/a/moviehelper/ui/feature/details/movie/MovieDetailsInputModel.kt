package com.a.moviehelper.ui.feature.details.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
const val MOVIE_DETAILS_INPUT_MODEL = "movie_details_input_model"

@Parcelize
data class MovieDetailsInputModel(val id: String) : Parcelable