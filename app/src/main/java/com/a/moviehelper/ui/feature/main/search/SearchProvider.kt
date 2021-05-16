package com.a.moviehelper.ui.feature.main.search

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchProvider {

    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeSearchFragment(): SearchFragment
}