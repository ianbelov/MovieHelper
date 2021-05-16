package com.a.moviehelper.ui.feature.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseActivity
import com.a.moviehelper.common.navigation.NavigationHost
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainView, MainPresenter>(R.layout.activity_main), MainView,
    NavigationHost {

    override val navController: NavController get() = findNavController(R.id.main_nav_host_fragment)

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.onViewCreated()
        binding.navView.setOnNavigationItemSelectedListener { item ->
            presenter.onBottomNavigationTabSelected(item.itemId)
            true
        }
    }
}