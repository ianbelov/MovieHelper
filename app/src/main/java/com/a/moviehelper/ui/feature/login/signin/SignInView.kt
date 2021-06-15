package com.godeltech.pokedex.ui.features.login.signin

import com.a.moviehelper.common.base.BaseView

interface SignInView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showEmailError(error: Int)
    fun showPasswordError(error: Int)
    fun showUnknownError()
    fun hideErrors()
}