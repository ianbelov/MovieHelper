package com.a.moviehelper.common.navigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("fragmentTab")
class TabFragmentNavigator(
    private var fragmentManager: FragmentManager,
    private var context: Context,
    private var containerId: Int
) : FragmentNavigator(context, fragmentManager, containerId) {

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        val tag = destination.id.toString()
        val transaction = fragmentManager.beginTransaction()
        val isInitialNavigation = fragmentManager.primaryNavigationFragment == null
        fragmentManager.fragments.forEach {
            transaction.hide(it)
        }

        var fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            val className = destination.className
            fragment = fragmentManager.fragmentFactory.instantiate(context.classLoader, className)
                .apply {
                    arguments = args
                }
            transaction.add(containerId, fragment, tag)
        } else {
            transaction.show(fragment)
        }

        transaction.setReorderingAllowed(true)
        transaction.commit()

        return if (isInitialNavigation) destination else null
    }

}