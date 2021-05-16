package com.a.moviehelper.core.network.movies

data class MovieModel(
    val title: String,
    val id: Int,
    val poster_path: String?,
    val release_date: String,
    val overview:String
)
