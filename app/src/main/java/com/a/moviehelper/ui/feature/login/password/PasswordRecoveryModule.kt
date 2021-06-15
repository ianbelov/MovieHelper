package com.godeltech.pokedex.ui.features.login.password

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PasswordRecoveryModule {

    @Binds
    @IntoMap
    @ViewModelKey(PasswordRecoveryPresenter::class)
    internal abstract fun bindPresenter(presenter: PasswordRecoveryPresenter): ViewModel
}