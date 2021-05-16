package com.a.moviehelper.ui.feature.onboarding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseActivity
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.ActivityOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity :
    BaseActivity<OnboardingView, OnboardingPresenter>(R.layout.activity_onboarding),
    OnboardingView {
    private val binding by viewBinding(ActivityOnboardingBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        binding.pagerView.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                presenter.onAdapterPageSelected(position)
            }
        })
        binding.signInButton.setOnClickListener {
            presenter.onSignInButtonClicked(this)
        }
        binding.signUpButton.setOnClickListener {
            presenter.onSignUpButtonClicked()
        }
        binding.skipButton.setOnClickListener {
            presenter.onSkipButtonClicked(this)
        }
    }

    override fun setAdapterPosition(position: Int) {
        binding.pagerView.currentItem = position
    }

    override fun setUpStartButton() {
        binding.nextButton.setOnClickListener {
            presenter.onStartButtonClicked()
        }
        binding.nextButton.text = "Start"
        setSignButtonsVisibility(View.VISIBLE)
    }

    override fun setUpNextButton() {
        binding.nextButton.setOnClickListener {
            presenter.onNextButtonClicked()
        }
        binding.nextButton.text = "Next"
        setSignButtonsVisibility(View.INVISIBLE)
    }

    override fun setSkipButtonVisibility(visibility: Int) {
        binding.skipButton.visibility = visibility
    }

    override fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setSignButtonsVisibility(visibility: Int) {
        binding.signInButton.visibility = visibility
        binding.signUpButton.visibility = visibility
    }

    private fun init() {
        val adapter = OnboardingViewPagerAdapter(this)
        binding.pagerView.adapter = adapter
        TabLayoutMediator(
            binding.indicatorView,
            binding.pagerView
        ) { tab, position ->
            tab.view.isClickable = false
        }.attach()
    }
}