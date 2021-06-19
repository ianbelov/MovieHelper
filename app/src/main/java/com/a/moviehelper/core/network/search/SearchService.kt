package com.a.moviehelper.core.network.search

import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.RapidResponse
import com.a.moviehelper.core.network.UtellyResponse
import com.a.moviehelper.core.network.movies.MoviePageModel
import com.a.moviehelper.core.network.movies.ShowPageModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
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

    @GET(NetworkUtils.RAPID_API_URL)
    fun searchProviders(
        @Query("source") source: String,
        @Query("source_id") sourceId: String,
        @Query("country") country: String,
        @Header("x-rapidapi-key") rapidApiKey: String,
        @Header("x-rapidapi-host") rapidApiHost: String
    ): Single<RapidResponse>
}