package com.a.moviehelper.ui.feature.details.movie

import com.a.moviehelper.ui.feature.details.DetailsModule
import com.a.moviehelper.ui.feature.main.search.SearchFragment
import com.a.moviehelper.ui.feature.main.search.SearchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MovieDetailsProvider {

    @ContributesAndroidInjector(modules = [DetailsModule::class])
    abstract fun contributeMovieDetailsFragment(): MovieDetailsFragment
}