package com.a.moviehelper.common.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MovieHelperNavHost : NavHostFragment() {

    override fun onCreateNavController(navController: NavController) {
        super.onCreateNavController(navController)
        navController.navigatorProvider.addNavigator(
            TabFragmentNavigator(
                childFragmentManager,
                requireContext(),
                id
            )
        )
    }
}