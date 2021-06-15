package com.godeltech.pokedex.ui.features.login

import android.content.Intent
import androidx.navigation.ActivityNavigator
import com.a.moviehelper.R
import com.a.moviehelper.common.navigation.submitNavigation
import com.a.moviehelper.common.rx.RxActivityProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginNavigator @Inject constructor(
    private val activityProvider: RxActivityProvider
) : ILoginNavigator {

    override fun initFlow(inputModel: LoginInputModel) {
        activityProvider.submitNavigation {
            val graph = this.navInflater.inflate(R.navigation.login_navigation)
            when (inputModel) {
                is LoginInputModel.SignIn -> {
                    graph.startDestination = R.id.login_sign_in
                }
                is LoginInputModel.SignUp -> {
                    graph.startDestination = R.id.login_sign_up
                }
            }
            setGraph(graph)
        }
    }

    override fun navigateToSignIn() {
        activityProvider.submitNavigation {
            navigate(R.id.login_sign_in)
        }
    }

    override fun navigateToSignUp() {
        activityProvider.submitNavigation {
            navigate(R.id.login_sign_up)
        }
    }

    override fun navigateToPasswordRecovery() {
        activityProvider.submitNavigation {
            navigate(R.id.login_forgot_password)
        }
    }

    override fun finishFlow() {
        activityProvider.submitActivity {
            finish()
        }
    }

    override fun navigateToMain() {
        activityProvider.submitNavigation {
            val extras = ActivityNavigator.Extras.Builder()
                .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                .build()
            navigate(R.id.login_main, null, null, extras)
        }
    }

    override fun navigateBack() {
        activityProvider.submitNavigation {
            popBackStack()
        }
    }

    override fun clearActivityBackstack() {
        activityProvider.submitActivity {
            finishAffinity()
            overridePendingTransition(0, 0)
        }
    }
}

interface ILoginNavigator {
    fun initFlow(inputModel: LoginInputModel)
    fun navigateToSignIn()
    fun navigateToSignUp()
    fun navigateToPasswordRecovery()
    fun finishFlow()
    fun navigateBack()
    fun navigateToMain()
    fun clearActivityBackstack()
}