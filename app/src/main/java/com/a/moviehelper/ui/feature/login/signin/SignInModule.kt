package com.godeltech.pokedex.ui.features.login.signin

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SignInModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInPresenter::class)
    internal abstract fun bindPresenter(presenter: SignInPresenter): ViewModel
}