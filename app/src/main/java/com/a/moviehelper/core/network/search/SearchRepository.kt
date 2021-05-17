package com.a.moviehelper.core.network.search

import com.a.moviehelper.core.network.NetworkUtils
import javax.inject.Inject

class SearchRepository @Inject constructor(private val searchService: SearchService) {

    fun searchMovies(query: String, page: Int) =
        searchService.searchMovies(query, page, NetworkUtils.API_KEY)

    fun searchShows(query: String, page: Int) =
        searchService.searchShows(query, page, NetworkUtils.API_KEY)

    fun searchGenre(query: Int, page: Int) =
        searchService.searchGenre(query, page, NetworkUtils.API_KEY)

}