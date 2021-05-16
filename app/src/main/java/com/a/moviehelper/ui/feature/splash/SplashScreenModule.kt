package com.a.moviehelper.ui.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.moviehelper.common.viewmodel.ViewModelFactory
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashScreenModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenPresenter::class)
    internal abstract fun bindViewModel(viewModel: SplashScreenPresenter): ViewModel
}