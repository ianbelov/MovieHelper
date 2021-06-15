package com.godeltech.pokedex.ui.features.login.signup

import com.a.moviehelper.ui.feature.login.signup.SignUpFragment
import com.godeltech.pokedex.core.firebase.FirebaseModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignUpProvider {

    @ContributesAndroidInjector(modules = [SignUpModule::class, FirebaseModule::class])
    abstract fun provideSignUpFragment(): SignUpFragment
}