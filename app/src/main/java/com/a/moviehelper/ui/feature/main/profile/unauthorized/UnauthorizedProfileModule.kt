package com.godeltech.pokedex.ui.features.main.profile.unauthorized

import androidx.lifecycle.ViewModel
import com.a.moviehelper.common.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UnauthorizedProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(UnauthorizedProfilePresenter::class)
    internal abstract fun bindPresenter(presenter: UnauthorizedProfilePresenter): ViewModel
}