package com.godeltech.pokedex.ui.features.login.password

import com.a.moviehelper.ui.feature.login.password.PasswordRecoveryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PasswordRecoveryProvider {

    @ContributesAndroidInjector(modules = [PasswordRecoveryModule::class])
    abstract fun contributePasswordRecovery(): PasswordRecoveryFragment
}