package com.godeltech.pokedex.ui.features.login.signin

import com.a.moviehelper.ui.feature.login.signin.SignInFragment
import com.godeltech.pokedex.core.firebase.FirebaseModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignInProvider {

    @ContributesAndroidInjector(modules = [SignInModule::class, FirebaseModule::class])
    abstract fun contributeSignInFragment(): SignInFragment
}