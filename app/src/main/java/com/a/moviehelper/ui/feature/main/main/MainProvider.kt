package com.a.moviehelper.ui.feature.main.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainProvider {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributePokedexFragment(): MainFragment
}