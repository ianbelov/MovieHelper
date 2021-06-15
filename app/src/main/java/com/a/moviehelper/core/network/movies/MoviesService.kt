package com.a.moviehelper.core.network.movies

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("page") page: Int,
        @Query("api_key") userKey: String?
    ): Single<MoviePageModel>

    @GET("tv/popular")
    fun getPopularShows(
        @Query("page") page: Int,
        @Query("api_key") userKey: String?
    ): Single<ShowPageModel>
}
