package com.godeltech.pokedex.ui.features.login.signin

import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.IS_FIRST_START
import com.a.moviehelper.core.PokedexSharedPreferences
import com.godeltech.pokedex.core.firebase.LoginRepository
import com.godeltech.pokedex.ui.features.login.ILoginNavigator
import com.godeltech.pokedex.ui.features.login.LoginErrorHandler
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class SignInPresenter @Inject constructor(
    private val navigator: ILoginNavigator,
    private val loginRepository: LoginRepository,
    private val schedulers: RxSchedulers,
    private val pokedexSharedPreferences: PokedexSharedPreferences
) : BasePresenter<SignInView>() {

    fun onSignInClicked(email: String, password: String) {
        loginRepository.signIn(email, password)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe {
                getView()?.showProgressBar()
                getView()?.hideErrors()
            }
            .subscribeBy(
                onSuccess = {
                    navigator.navigateToMain()
                    navigator.clearActivityBackstack()
                    pokedexSharedPreferences.put(IS_FIRST_START, false)
                },
                onError = { error ->
                    getView()?.hideProgressBar()
                    LoginErrorHandler(
                        onUnknownError = { getView()?.showUnknownError() },
                        onEmailError = { getView()?.showEmailError(it) },
                        onPasswordError = { getView()?.showPasswordError(it) }
                    ).handleError(error)
                })
            .toAutoDisposable()
    }

    fun onForgotPasswordClicked() {
        navigator.navigateToPasswordRecovery()
    }

    fun onBackClicked() {
        navigator.finishFlow()
    }
}