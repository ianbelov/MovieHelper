package com.a.moviehelper.di.module

import android.content.Context
import com.a.moviehelper.core.sharedpref.SharedPrefProvider
import dagger.Module
import dagger.Provides

@Module
class SharedPrefModule() {

    @Provides
    fun provideSharedPreferences(context: Context): SharedPrefProvider {
        return SharedPrefProvider(context)
    }
}