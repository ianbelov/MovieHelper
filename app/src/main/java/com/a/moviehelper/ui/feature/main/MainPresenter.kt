package com.a.moviehelper.ui.feature.main

import android.util.Log
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BasePresenter
import com.godeltech.pokedex.core.firebase.LoginRepository
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private var navigator: IMainNavigator,
    private val loginRepository: LoginRepository
) : BasePresenter<MainView>() {

    private var isAuthorized = false

    fun onViewCreated() {

        navigator.initFlow()
        loginRepository.getUser()
            .subscribeBy(
                onSuccess = {
                    Log.d("onViewCreated: ", it.toString())
                    isAuthorized = true
                }, onError = {
                    isAuthorized = false
                    Log.d("rx", it.message.orEmpty())
                })

    }

    fun onBottomNavigationTabSelected(newTabId: Int) {
        when (newTabId) {
            R.id.main -> navigator.navigateToMain()
            R.id.search -> navigator.navigateToSearch()
            R.id.profile ->
                if (isAuthorized) {
                    navigator.navigateToAuthorizedProfile()
                } else {
                    navigator.navigateToUnauthorizedProfile()
                }
        }
    }

}
