package com.a.moviehelper.di

import android.app.Application
import com.a.moviehelper.MovieApplication
import com.a.moviehelper.core.network.module.NetworkModule
import com.a.moviehelper.core.network.module.ParserModule
import com.a.moviehelper.core.network.module.ServicesModule
import com.a.moviehelper.di.module.ActivityBindingModule
import com.a.moviehelper.di.module.ContextModule
import com.a.moviehelper.di.module.SharedPrefModule
import com.godeltech.pokedex.core.firebase.FirebaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        NetworkModule::class,
        ParserModule::class,
        ContextModule::class,
        SharedPrefModule::class,
        ServicesModule::class,
        FirebaseModule::class]
)
interface AppComponent : AndroidInjector<MovieApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(myApp: MovieApplication)
}