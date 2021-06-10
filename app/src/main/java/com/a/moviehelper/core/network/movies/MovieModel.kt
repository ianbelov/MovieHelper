package com.a.moviehelper.core.network.movies

data class MovieModel(
    val title: String,
    val imdb_id: String?,
    val id: Int,
    val budget: String?,
    val revenue: String?,
    val poster_path: String?,
    val backdrop_path: String?,
    val release_date: String?,
    val overview:String?
)
