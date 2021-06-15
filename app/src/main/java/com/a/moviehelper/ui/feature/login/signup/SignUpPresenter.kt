package com.godeltech.pokedex.ui.features.login.signup

import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.IS_FIRST_START
import com.a.moviehelper.core.PokedexSharedPreferences
import com.godeltech.pokedex.core.firebase.LoginRepository
import com.godeltech.pokedex.ui.features.login.ILoginNavigator
import com.godeltech.pokedex.ui.features.login.LoginErrorHandler
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class SignUpPresenter @Inject constructor(
    val navigator: ILoginNavigator,
    val repository: LoginRepository,
    val schedulers: RxSchedulers,
    val pokedexSharedPreferences: PokedexSharedPreferences
) : BasePresenter<SignUpView>() {

    fun onSignUpClicked(email: String, password: String, name: String) {
        repository.signUp(email, password, name)
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
                        onPasswordError = { getView()?.showPasswordError(it) },
                        onNameError = { getView()?.showNameError(it) }
                    ).handleError(error)
                })
            .toAutoDisposable()
    }

    fun onBackClicked() {
        navigator.finishFlow()
    }
}