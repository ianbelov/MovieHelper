package com.a.moviehelper.core.network.details

import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.core.network.movies.ShowModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailsService {

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") userKey: String?
    ): Single<MovieModel>

    @GET("tv/{tv_id}")
    fun getShowDetails(
        @Path("tv_id") page: Int,
        @Query("api_key") userKey: String?
    ): Single<ShowModel>
}