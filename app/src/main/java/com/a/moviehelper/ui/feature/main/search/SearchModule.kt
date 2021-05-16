package com.a.moviehelper.ui.feature.main.search

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchPresenter::class)
    internal abstract fun bindPresenter(presenter: SearchPresenter): ViewModel
}