package com.godeltech.pokedex.ui.features.login.password

import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.godeltech.pokedex.core.firebase.LoginRepository
import com.godeltech.pokedex.ui.features.login.ILoginNavigator
import com.godeltech.pokedex.ui.features.login.LoginErrorHandler
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class PasswordRecoveryPresenter @Inject constructor(
    private val loginRepository: LoginRepository,
    private val schedulers: RxSchedulers,
    private val navigator: ILoginNavigator
) : BasePresenter<PasswordRecoveryView>() {

    fun onSumbitClicked(email: String) {
        loginRepository.sendEmail(email)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe {
                getView()?.showProgressbar()
                getView()?.hideErrors()
            }
            .doFinally { getView()?.hideProgressbar() }
            .subscribeBy(
                onComplete = {
                    navigator.navigateBack()
                },
                onError = { error ->
                    LoginErrorHandler(
                        onUnknownError = { getView()?.showUnknownError() },
                        onEmailError = { getView()?.showEmailError(it) }
                    ).handleError(error)
                })
            .toAutoDisposable()
    }

    fun onBackClicked() {
        navigator.navigateBack()
    }

}