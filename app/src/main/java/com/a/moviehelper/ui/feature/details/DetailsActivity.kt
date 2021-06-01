package com.a.moviehelper.ui.feature.details

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseActivity
import com.a.moviehelper.common.navigation.NavigationHost

class DetailsActivity : BaseActivity<DetailsView, DetailsPresenter>(R.layout.activity_details),
    NavigationHost, DetailsView {

    companion object {
        private const val INPUT_MODEL_KEY = "id"
    }

    override val navController: NavController get() = findNavController(R.id.detail_navigation_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewCreated(intent.getParcelableExtra(INPUT_MODEL_KEY))
    }
}