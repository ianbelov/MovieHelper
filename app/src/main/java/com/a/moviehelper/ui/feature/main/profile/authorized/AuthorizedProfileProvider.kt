package com.godeltech.pokedex.ui.features.main.profile.authorized

import com.a.moviehelper.ui.feature.main.profile.authorized.AuthorizedProfileFragment
import com.godeltech.pokedex.core.firebase.FirebaseModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthorizedProfileProvider {

    @ContributesAndroidInjector(modules = [AuthorizedProfileModule::class, FirebaseModule::class])
    abstract fun provideAuthorizedProfileFragment(): AuthorizedProfileFragment
}