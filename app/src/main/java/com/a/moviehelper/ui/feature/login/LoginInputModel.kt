package com.godeltech.pokedex.ui.features.login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

const val LOGIN_INPUT_MODEL_KEY = "login_input_model_key"

sealed class LoginInputModel : Parcelable {

    @Parcelize
    object SignIn : LoginInputModel()

    @Parcelize
    object SignUp : LoginInputModel()

}