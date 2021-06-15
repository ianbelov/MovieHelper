package com.a.moviehelper.ui.feature.login.signin

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.FragmentSignInBinding
import com.godeltech.pokedex.common.utils.setDefaultIconTintStateList
import com.godeltech.pokedex.common.utils.setErrorIconTintStateList
import com.godeltech.pokedex.ui.features.login.signin.SignInPresenter
import com.godeltech.pokedex.ui.features.login.signin.SignInView

class SignInFragment : BaseFragment<SignInView, SignInPresenter>(R.layout.fragment_sign_in),
    SignInView {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setOnClickListener {
            hideKeyboard()
            binding.root.clearFocus()
        }

        binding.signInButton.setOnClickListener {
            binding.root.clearFocus()
            presenter.onSignInClicked(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString(),
            )
        }

        binding.forgotPasswordButton.setOnClickListener {
            presenter.onForgotPasswordClicked()
        }
    }

    override fun showUnknownError() {

    }

    override fun showPasswordError(error: Int) {
        binding.passwordInputLayout.error = getString(error)
        binding.passwordInputLayout.setErrorIconTintStateList()
    }

    override fun showEmailError(error: Int) {
        binding.emailInputLayout.error = getString(error)
        binding.emailInputLayout.setErrorIconTintStateList()
    }

    override fun hideErrors() {
        binding.emailInputLayout.isErrorEnabled = false
        binding.emailInputLayout.isErrorEnabled = true
        binding.emailInputLayout.setDefaultIconTintStateList()

        binding.passwordInputLayout.isErrorEnabled = false
        binding.passwordInputLayout.isErrorEnabled = true
        binding.passwordInputLayout.setDefaultIconTintStateList()
    }

    override fun showProgressBar() {
        binding.progressIndicatorView.visibility = View.VISIBLE
        binding.rootViewsGroup.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
        binding.rootViewsGroup.visibility = View.VISIBLE
        binding.progressIndicatorView.visibility = View.GONE
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}