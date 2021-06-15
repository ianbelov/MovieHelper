package com.godeltech.pokedex.ui.features.login

import com.a.moviehelper.common.base.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private var navigator: ILoginNavigator) : BasePresenter<LoginView>() {

    fun onViewCreated(inputModel: LoginInputModel) {
        navigator.initFlow(inputModel)
    }

}