package com.a.moviehelper.ui.feature.details.movie

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MovieDetailsProvider {

    @ContributesAndroidInjector(modules = [MovieDetailsModule::class])
    abstract fun contributeMovieDetailsFragment(): MovieDetailsFragment
}