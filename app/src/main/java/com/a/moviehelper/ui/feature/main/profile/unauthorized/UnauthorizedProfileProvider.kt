package com.godeltech.pokedex.ui.features.main.profile.unauthorized

import com.a.moviehelper.ui.feature.main.profile.unauthorized.UnauthorizedProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UnauthorizedProfileProvider {

    @ContributesAndroidInjector(modules = [UnauthorizedProfileModule::class])
    abstract fun contributeUnauthFragment(): UnauthorizedProfileFragment
}