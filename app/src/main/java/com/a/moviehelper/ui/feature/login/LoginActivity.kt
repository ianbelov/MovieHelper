package com.a.moviehelper.ui.feature.login

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseActivity
import com.a.moviehelper.common.navigation.NavigationHost
import com.godeltech.pokedex.ui.features.login.LOGIN_INPUT_MODEL_KEY
import com.godeltech.pokedex.ui.features.login.LoginPresenter
import com.godeltech.pokedex.ui.features.login.LoginView

class LoginActivity : BaseActivity<LoginView, LoginPresenter>(R.layout.activity_login),
    NavigationHost,
    LoginView {

    override val navController: NavController get() = findNavController(R.id.login_nav_host)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewCreated(intent.getParcelableExtra(LOGIN_INPUT_MODEL_KEY)!!)
    }

}