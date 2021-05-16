package com.a.moviehelper.common.rx

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.a.moviehelper.common.listeners.DefaultActivityLifecycleCallbacks
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.UnicastSubject

class RxActivityProvider constructor(
    private val application: Application,
    private val schedulers: RxSchedulers
) {

    private val activityCallbacks: DefaultActivityLifecycleCallbacks

    private var subject = UnicastSubject.create<AppCompatActivity.() -> Unit>()

    private var disposable: Disposable? = null

    init {
        activityCallbacks = object : DefaultActivityLifecycleCallbacks() {

            override fun onActivityResumed(activity: Activity) {
                if (activity is AppCompatActivity) {
                    synchronized(this@RxActivityProvider) {
                        disposable = subject.observeOn(schedulers.ui()).subscribe { activity.it() }
                    }
                }
            }

            override fun onActivityPaused(activity: Activity) {
                if (activity is AppCompatActivity) {
                    synchronized(this@RxActivityProvider) {
                        disposable?.dispose()
                        disposable = null
                        subject = UnicastSubject.create()
                    }
                }
            }
        }

        application.registerActivityLifecycleCallbacks(activityCallbacks)
    }

    fun submitActivity(activityBlock: AppCompatActivity.() -> Unit) {
        synchronized(this@RxActivityProvider) {
            subject.onNext(activityBlock)
        }
    }
}