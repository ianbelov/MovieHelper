package com.a.moviehelper.core.network.movies

data class ShowModel(
    val name: String,
    val imdb_id: String?,
    val id: Int,
    val poster_path: String?,
    val backdrop_path: String?,
    val overview:String?,
    val first_air_date: String?
)