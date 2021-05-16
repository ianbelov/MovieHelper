package com.a.moviehelper.di.module

import android.app.Application
import android.content.Context
import com.a.moviehelper.common.rx.RxActivityProvider
import com.a.moviehelper.common.rx.RxSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun providerActivityProvider(application: Application, schedulers: RxSchedulers): RxActivityProvider {
        return RxActivityProvider(application, schedulers)
    }
}