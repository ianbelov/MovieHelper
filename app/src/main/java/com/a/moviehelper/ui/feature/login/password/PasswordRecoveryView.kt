package com.godeltech.pokedex.ui.features.login.password

import com.a.moviehelper.common.base.BaseView


interface PasswordRecoveryView : BaseView {
    fun showProgressbar()
    fun hideProgressbar()
    fun showEmailError(error: Int)
    fun showUnknownError()
    fun hideErrors()
}