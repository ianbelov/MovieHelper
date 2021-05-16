package com.a.moviehelper.ui.feature.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.a.moviehelper.ui.feature.onboarding.pages.FirstOnboardingFragment
import com.a.moviehelper.ui.feature.onboarding.pages.FourthOnboardingFragment
import com.a.moviehelper.ui.feature.onboarding.pages.SecondOnboardingFragment
import com.a.moviehelper.ui.feature.onboarding.pages.ThirdOnboardingFragment

class OnboardingViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            OnboardingPresenter.OnboardingViewPager.FIRST_POSITION -> return FirstOnboardingFragment()
            OnboardingPresenter.OnboardingViewPager.SECOND_POSITION -> return SecondOnboardingFragment()
            OnboardingPresenter.OnboardingViewPager.THIRD_POSITION -> return ThirdOnboardingFragment()
            OnboardingPresenter.OnboardingViewPager.LAST_POSITION -> return FourthOnboardingFragment()
        }
        return FirstOnboardingFragment()
    }

}