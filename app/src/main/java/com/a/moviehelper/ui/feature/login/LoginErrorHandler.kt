package com.godeltech.pokedex.ui.features.login

import com.a.moviehelper.R
import com.google.firebase.auth.FirebaseAuthException

const val ERROR_INVALID_EMAIL = "ERROR_INVALID_EMAIL"
const val ERROR_EMAIL_ALREADY_IN_USE = "ERROR_EMAIL_ALREADY_IN_USE"
const val ERROR_USER_NOT_FOUND = "ERROR_USER_NOT_FOUND"
const val ERROR_WRONG_PASSWORD = "ERROR_WRONG_PASSWORD"
const val ERROR_CREDENTIAL_ALREADY_IN_USE = "ERROR_CREDENTIAL_ALREADY_IN_USE"
const val ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIA =
    "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIA"

class LoginErrorHandler constructor(
    private val onUnknownError: () -> Unit = {},
    private val onNameError: (id: Int) -> Unit = {},
    private val onEmailError: (id: Int) -> Unit = {},
    private val onPasswordError: (id: Int) -> Unit = {}
) {

    fun handleError(error: Throwable) {
        if (error is FirebaseAuthException) {
            handleErrorCode(error.errorCode)
        } else {
            onUnknownError()
        }
    }

    private fun handleErrorCode(errorCode: String) {
        when (errorCode) {
            ERROR_INVALID_EMAIL, ERROR_EMAIL_ALREADY_IN_USE, ERROR_USER_NOT_FOUND -> {
                onEmailError(getErrorResId(errorCode))
            }
            ERROR_WRONG_PASSWORD, ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIA -> {
                onPasswordError(getErrorResId(errorCode))
            }
            ERROR_CREDENTIAL_ALREADY_IN_USE -> {
                onNameError(getErrorResId(errorCode))
            }
            else -> onUnknownError()
        }
    }

    private fun getErrorResId(error: String): Int {
        when (error) {
            ERROR_INVALID_EMAIL -> return R.string.ERROR_INVALID_EMAIL
            ERROR_WRONG_PASSWORD -> return R.string.ERROR_WRONG_PASSWORD
            ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIA -> return R.string.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIA
            ERROR_EMAIL_ALREADY_IN_USE -> return R.string.ERROR_EMAIL_ALREADY_IN_USE
            ERROR_CREDENTIAL_ALREADY_IN_USE -> return R.string.ERROR_CREDENTIAL_ALREADY_IN_USE
            ERROR_USER_NOT_FOUND -> return R.string.ERROR_USER_NOT_FOUND
        }
        return 0
    }

}