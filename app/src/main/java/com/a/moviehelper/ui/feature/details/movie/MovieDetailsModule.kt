package com.a.moviehelper.ui.feature.details.movie

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieDetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsPresenter::class)
    internal abstract fun bindPresenter(presenter: MovieDetailsPresenter): ViewModel
}