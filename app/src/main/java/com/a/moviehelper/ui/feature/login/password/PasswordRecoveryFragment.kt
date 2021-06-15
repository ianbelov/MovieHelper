package com.a.moviehelper.ui.feature.login.password

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.FragmentPasswordRecoveryBinding
import com.godeltech.pokedex.common.utils.setDefaultIconTintStateList
import com.godeltech.pokedex.common.utils.setErrorIconTintStateList
import com.godeltech.pokedex.ui.features.login.password.PasswordRecoveryPresenter
import com.godeltech.pokedex.ui.features.login.password.PasswordRecoveryView


class PasswordRecoveryFragment :
    BaseFragment<PasswordRecoveryView, PasswordRecoveryPresenter>(R.layout.fragment_password_recovery),
    PasswordRecoveryView {

    private val binding by viewBinding(FragmentPasswordRecoveryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            binding.root.clearFocus()
            hideKeyboard()
        }
        binding.submitButton.setOnClickListener {
            presenter.onSumbitClicked(binding.emailEditText.text.toString())
        }

    }

    override fun showUnknownError() {

    }

    override fun showEmailError(error: Int) {
        binding.emailInputLayout.error = getString(error)
        binding.emailInputLayout.setErrorIconTintStateList()
    }

    override fun hideErrors() {
        binding.emailInputLayout.isErrorEnabled = false
        binding.emailInputLayout.isErrorEnabled = true
        binding.emailInputLayout.setDefaultIconTintStateList()
    }

    override fun showProgressbar() {
        binding.rootViewsGroup.visibility = View.INVISIBLE
        binding.progressIndicatorView.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        binding.rootViewsGroup.visibility = View.VISIBLE
        binding.progressIndicatorView.visibility = View.GONE
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}