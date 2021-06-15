package com.a.moviehelper.core.network.search

import com.a.moviehelper.core.network.movies.MoviePageModel
import com.a.moviehelper.core.network.movies.ShowPageModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

sealed interface SearchService {

    @GET("search/movie")
    fun searchMovies(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("api_key") userKey: String?
    ): Single<MoviePageModel>

    @GET("search/tv")
    fun searchShows(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("api_key") userKey: String?
    ): Single<ShowPageModel>

    @GET("discover/movie")
    fun searchGenre(
        @Query("with_genres") id: Int,
        @Query("page") page: Int,
        @Query("api_key") userKey: String?
    ): Single<MoviePageModel>
}