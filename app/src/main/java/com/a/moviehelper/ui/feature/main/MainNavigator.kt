package com.a.moviehelper.ui.feature.main

import androidx.core.os.bundleOf
import com.a.moviehelper.R
import com.a.moviehelper.common.navigation.submitNavigation
import com.a.moviehelper.common.rx.RxActivityProvider
import com.a.moviehelper.ui.feature.details.DETAILS_INPUT_MODEL_KEY
import com.a.moviehelper.ui.feature.details.DetailsInputModel
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsInputModel
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val activityProvider: RxActivityProvider
) : IMainNavigator {

    override fun initFlow() {
        activityProvider.submitNavigation {
            val graph = this.navInflater.inflate(R.navigation.main_navigation).apply {
                startDestination = R.id.main_search
            }
            this.graph = graph
        }
    }

    override fun navigateToAuthorizedProfile() {
        activityProvider.submitNavigation {
            navigate(R.id.main_authorized_profile)
        }
    }

    override fun navigateToUnauthorizedProfile() {
        activityProvider.submitNavigation {
            navigate(R.id.main_profile)
        }
    }

    override fun navigateToSearch() {
        activityProvider.submitNavigation {
            navigate(R.id.main_search)
        }
    }

    override fun navigateToMain() {
        activityProvider.submitNavigation {
            navigate(R.id.main_main)
        }
    }

    override fun navigateToDetails(id: DetailsInputModel) {
        activityProvider.submitNavigation {
            navigate(R.id.main_details, bundleOf(DETAILS_INPUT_MODEL_KEY to id))
        }
    }
}

interface IMainNavigator {
    fun initFlow()
    fun navigateToAuthorizedProfile()
    fun navigateToUnauthorizedProfile()
    fun navigateToSearch()
    fun navigateToMain()
    fun navigateToDetails(id: DetailsInputModel)
}
