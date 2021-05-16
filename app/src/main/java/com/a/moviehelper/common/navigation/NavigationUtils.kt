package com.a.moviehelper.common.navigation

import androidx.navigation.NavController
import com.a.moviehelper.common.rx.RxActivityProvider

fun RxActivityProvider.submitNavigation(navigation: NavController.() -> Unit) {
    submitActivity {
        if (this is NavigationHost) {
            navController.navigation()
        }
    }
}

interface NavigationHost {
    val navController: NavController
}
