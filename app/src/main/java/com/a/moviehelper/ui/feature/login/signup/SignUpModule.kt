package com.godeltech.pokedex.ui.features.login.signup

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SignUpModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignUpPresenter::class)
    internal abstract fun bindPresenter(presenter: SignUpPresenter): ViewModel
}