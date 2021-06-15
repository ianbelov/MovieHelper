package com.a.moviehelper.ui.feature.main.profile.unauthorized

import android.os.Bundle
import android.view.View
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.FragmentProfileBinding
import com.godeltech.pokedex.ui.features.main.profile.unauthorized.UnauthorizedProfilePresenter
import com.godeltech.pokedex.ui.features.main.profile.unauthorized.UnauthorizedProfileView

class UnauthorizedProfileFragment :
    BaseFragment<UnauthorizedProfileView, UnauthorizedProfilePresenter>(R.layout.fragment_profile),
    UnauthorizedProfileView {
    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            presenter.onSignInButtonClicked()
        }

        binding.signUpButton.setOnClickListener {
            presenter.onSignUpButtonClicked()
        }
    }
}