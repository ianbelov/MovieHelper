package com.a.moviehelper.core.network.movies

import com.a.moviehelper.core.network.NetworkUtils
import javax.inject.Inject

class MainRepository @Inject constructor(private val moviesService: MoviesService) {

    fun getMovies(page: Int) = moviesService.getPopularMovies(page, NetworkUtils.API_KEY)

    fun getShows(page: Int) = moviesService.getPopularShows(page, NetworkUtils.API_KEY)
}