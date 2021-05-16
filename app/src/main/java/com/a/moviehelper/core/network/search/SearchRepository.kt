package com.a.moviehelper.core.network.search

import com.a.moviehelper.core.network.NetworkUtils
import javax.inject.Inject

class SearchRepository @Inject constructor(private val searchService: SearchService) {

    fun search(query: String, page: Int) =
        searchService.searchMovies(query, page, NetworkUtils.API_KEY)

}