package com.a.moviehelper.ui.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseActivity
import com.a.moviehelper.ui.feature.main.MainActivity
import com.a.moviehelper.ui.feature.onboarding.OnboardingActivity

class SplashScreenActivity : BaseActivity<SplashScreenView, SplashScreenPresenter>(),
    SplashScreenView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        presenter.onStartActivity()
    }

    override fun startFromMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun startFromOnboardingActivity() {
        startActivity(Intent(this, OnboardingActivity::class.java))
        finish()
    }

}