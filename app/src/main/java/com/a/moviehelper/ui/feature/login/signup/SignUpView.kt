package com.godeltech.pokedex.ui.features.login.signup

import com.a.moviehelper.common.base.BaseView

interface SignUpView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showEmailError(errorResId: Int)
    fun showPasswordError(errorResId: Int)
    fun showNameError(errorResId: Int)
    fun showUnknownError()
    fun hideErrors()
}