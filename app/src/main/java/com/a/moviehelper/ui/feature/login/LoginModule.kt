package com.godeltech.pokedex.ui.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.moviehelper.common.viewmodel.ViewModelFactory
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    internal abstract fun bindNavigator(navigator: LoginNavigator): ILoginNavigator

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginPresenter::class)
    internal abstract fun bindPresenter(presenter: LoginPresenter): ViewModel
}