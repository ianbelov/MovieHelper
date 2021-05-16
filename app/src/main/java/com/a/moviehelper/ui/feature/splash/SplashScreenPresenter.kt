package com.a.moviehelper.ui.feature.splash

import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.core.sharedpref.SharedPrefProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val IS_FIRST_START: String = "isFirstStart"

class SplashScreenPresenter @Inject constructor(
    private val sharedPreferences: SharedPrefProvider
) : BasePresenter<SplashScreenView>() {

    fun onStartActivity() {
        Observable.just(sharedPreferences.get(IS_FIRST_START, true))
            .delay(2, TimeUnit.SECONDS)
            .subscribeBy(onNext = {
                if (it) {
                    sharedPreferences.put(IS_FIRST_START, false)
                    getView()?.startFromOnboardingActivity()
                } else {
                    getView()?.startFromMainActivity()
                }
            })

    }
}