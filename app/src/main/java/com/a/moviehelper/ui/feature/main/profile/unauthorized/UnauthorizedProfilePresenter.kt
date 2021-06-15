package com.godeltech.pokedex.ui.features.main.profile.unauthorized

import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.ui.feature.main.IMainNavigator
import com.godeltech.pokedex.ui.features.login.LoginInputModel
import javax.inject.Inject

class UnauthorizedProfilePresenter @Inject constructor(private val navigator: IMainNavigator) :
    BasePresenter<UnauthorizedProfileView>() {

    fun onSignInButtonClicked() {
        navigator.navigateToLogin(LoginInputModel.SignIn)
    }

    fun onSignUpButtonClicked() {
        navigator.navigateToLogin(LoginInputModel.SignUp)
    }
}