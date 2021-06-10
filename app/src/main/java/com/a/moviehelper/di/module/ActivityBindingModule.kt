package com.a.moviehelper.di.module

import com.a.moviehelper.ui.feature.details.DetailsActivity
import com.a.moviehelper.ui.feature.details.DetailsModule
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsProvider
import com.a.moviehelper.ui.feature.details.show.ShowDetailsProvider
import com.a.moviehelper.ui.feature.main.MainActivity
import com.a.moviehelper.ui.feature.main.MainModule
import com.a.moviehelper.ui.feature.main.main.MainProvider
import com.a.moviehelper.ui.feature.main.search.SearchProvider
import com.a.moviehelper.ui.feature.onboarding.OnboardingActivity
import com.a.moviehelper.ui.feature.onboarding.OnboardingModule
import com.a.moviehelper.ui.feature.splash.SplashScreenActivity
import com.a.moviehelper.ui.feature.splash.SplashScreenModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [SplashScreenModule::class])
    abstract fun contributeSplash(): SplashScreenActivity

    @ContributesAndroidInjector(modules = [OnboardingModule::class])
    abstract fun contributeOnboarding(): OnboardingActivity

    @ContributesAndroidInjector(modules = [MainModule::class, MainProvider::class, SearchProvider::class])
    abstract fun contributeMain(): MainActivity

    @ContributesAndroidInjector(modules = [DetailsModule::class, MovieDetailsProvider::class, ShowDetailsProvider::class])
    abstract fun contributeDetails(): DetailsActivity
}