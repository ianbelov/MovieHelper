package com.a.moviehelper.core.network.module

import com.a.moviehelper.core.network.details.DetailsService
import com.a.moviehelper.core.network.movies.MoviesService
import com.a.moviehelper.core.network.search.SearchService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ServicesModule {

    @Provides
    @Singleton
    fun provideMoviesService(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)

    @Provides
    @Singleton
    fun provideSearchService(retrofit: Retrofit) = retrofit.create(SearchService::class.java)

    @Provides
    @Singleton
    fun provideDetailsService(retrofit: Retrofit) = retrofit.create(DetailsService::class.java)
}