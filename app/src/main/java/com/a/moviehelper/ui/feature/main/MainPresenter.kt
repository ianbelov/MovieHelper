package com.a.moviehelper.ui.feature.main

import com.a.moviehelper.R
import com.a.moviehelper.common.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private var navigator: IMainNavigator
) : BasePresenter<MainView>() {

    private var isAuthorized = false

    fun onViewCreated() {
        navigator.initFlow()
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
