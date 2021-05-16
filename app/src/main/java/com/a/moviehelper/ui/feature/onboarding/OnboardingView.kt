package com.a.moviehelper.ui.feature.onboarding

import com.a.moviehelper.common.base.BaseView

interface OnboardingView : BaseView {
    fun setAdapterPosition(position: Int)
    fun setUpStartButton()
    fun setUpNextButton()
    fun setSkipButtonVisibility(visibility: Int)
    fun toast(message: String)
}