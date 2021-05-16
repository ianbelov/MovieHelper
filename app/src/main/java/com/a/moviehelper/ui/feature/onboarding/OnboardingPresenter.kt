package com.a.moviehelper.ui.feature.onboarding

import android.content.Context
import android.content.Intent
import android.view.View
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.ui.feature.main.MainActivity
import javax.inject.Inject

class OnboardingPresenter @Inject constructor() : BasePresenter<OnboardingView>() {
    object OnboardingViewPager {
        const val FIRST_POSITION = 0
        const val SECOND_POSITION = 1
        const val THIRD_POSITION = 2
        const val LAST_POSITION = 3
    }

    var position: Int = OnboardingViewPager.FIRST_POSITION

    fun onNextButtonClicked() {
        getView()?.setAdapterPosition(++position)
    }

    fun onStartButtonClicked() {
        getView()?.toast("Start main")
    }

    fun onSignInButtonClicked(context: Context) {
//        val intent = Intent(context, LoginActivity::class.java)
//        intent.putExtra(LOGIN_INPUT_MODEL_KEY, LoginInputModel.SignIn)
//        context.startActivity(intent)
    }

    fun onSignUpButtonClicked() {}

    fun onAdapterPageSelected(position: Int) {
        this.position = position
        when (position) {
            OnboardingViewPager.LAST_POSITION -> {
                getView()?.setSkipButtonVisibility(View.GONE)
                getView()?.setUpStartButton()
            }
            OnboardingViewPager.FIRST_POSITION -> {
                getView()?.setSkipButtonVisibility(View.GONE)
                getView()?.setUpNextButton()
            }
            else -> {
                getView()?.setSkipButtonVisibility(View.VISIBLE)
                getView()?.setUpNextButton()
            }
        }
    }

    fun onSkipButtonClicked(activity: OnboardingActivity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }
}