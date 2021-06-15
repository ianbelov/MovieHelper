package com.godeltech.pokedex.ui.features.main.profile.authorized

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthorizedProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizedProfilePresenter::class)
    internal abstract fun bindPresenter(presenter: AuthorizedProfilePresenter): ViewModel
}