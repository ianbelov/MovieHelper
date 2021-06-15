package com.a.moviehelper.ui.feature.main.main

import com.a.moviehelper.common.base.BaseView
import com.a.moviehelper.core.network.movies.MovieModel

interface MainView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showMovies(movies: List<MovieModel>)
    fun showShows(shows: List<MovieModel>)
}