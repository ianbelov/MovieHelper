package com.a.moviehelper.ui.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.moviehelper.common.viewmodel.ViewModelFactory
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    internal abstract fun bindNavigator(navigator: MainNavigator): IMainNavigator

    @Binds
    @IntoMap
    @ViewModelKey(MainPresenter::class)
    internal abstract fun bindPresenter(presenter: MainPresenter): ViewModel
}
