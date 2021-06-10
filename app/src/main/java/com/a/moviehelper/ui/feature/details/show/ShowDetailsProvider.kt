package com.a.moviehelper.ui.feature.details.show

import com.a.moviehelper.ui.feature.details.movie.MovieDetailsFragment
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ShowDetailsProvider {

    @ContributesAndroidInjector(modules = [ShowDetailsModule::class])
    abstract fun contributeShowDetailsFragment(): ShowDetailsFragment
}