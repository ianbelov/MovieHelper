package com.a.moviehelper.core.network.details

import com.a.moviehelper.core.network.NetworkUtils
import javax.inject.Inject

class DetailsRepository @Inject constructor(val service: DetailsService) {

    fun getMovieDetails(id:String) = service.getMovieDetails(id.toInt(), NetworkUtils.API_KEY)
    fun getShowDetails(id:String) = service.getShowDetails(id.toInt(), NetworkUtils.API_KEY)
}