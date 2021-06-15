package com.a.moviehelper.ui.feature.details.show

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ShowDetailsProvider {

    @ContributesAndroidInjector(modules = [ShowDetailsModule::class])
    abstract fun contributeShowDetailsFragment(): ShowDetailsFragment
}