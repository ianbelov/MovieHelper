package com.a.moviehelper.ui.feature.main.main

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentPresenter::class)
    internal abstract fun bindPresenter(presenter: MainFragmentPresenter): ViewModel
}