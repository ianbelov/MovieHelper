package com.a.moviehelper.ui.feature.login.signup

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.FragmentSignUpBinding
import com.godeltech.pokedex.common.utils.setDefaultIconTintStateList
import com.godeltech.pokedex.common.utils.setErrorIconTintStateList
import com.godeltech.pokedex.ui.features.login.signup.SignUpPresenter
import com.godeltech.pokedex.ui.features.login.signup.SignUpView

class SignUpFragment : BaseFragment<SignUpView, SignUpPresenter>(R.layout.fragment_sign_up),
    SignUpView {

    private val binding by viewBinding(FragmentSignUpBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setOnClickListener {
            hideKeyboard()
            binding.root.clearFocus()
        }

        binding.signUpButton.setOnClickListener {
            binding.root.clearFocus()
            presenter.onSignUpClicked(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString(),
                binding.nameEditText.text.toString()
            )
        }
    }

    override fun showNameError(errorResId: Int) {
        binding.nameInputLayout.error = getString(errorResId)
        binding.nameInputLayout.setErrorIconTintStateList()
    }

    override fun showEmailError(errorResId: Int) {
        binding.emailInputLayout.error = getString(errorResId)
        binding.emailInputLayout.setErrorIconTintStateList()
    }

    override fun showPasswordError(errorResId: Int) {
        binding.passwordInputLayout.error = getString(errorResId)
        binding.passwordInputLayout.setErrorIconTintStateList()
    }

    override fun showUnknownError() {

    }

    override fun hideErrors() {
        binding.nameInputLayout.isErrorEnabled = false
        binding.nameInputLayout.isErrorEnabled = true
        binding.nameInputLayout.setDefaultIconTintStateList()

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