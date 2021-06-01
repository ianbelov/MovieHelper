package com.a.moviehelper.ui.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.moviehelper.common.viewmodel.ViewModelFactory
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailsModule {

    @Binds
    internal abstract fun bindNavigator(navigator: DetailNavigator): IDetailNavigator

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DetailsPresenter::class)
    internal abstract fun bindPresenter(presenter: DetailsPresenter): ViewModel
}