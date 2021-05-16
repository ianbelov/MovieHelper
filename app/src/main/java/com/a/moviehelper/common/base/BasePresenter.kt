package com.a.moviehelper.common.base

import android.annotation.SuppressLint
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

@SuppressLint("StaticFieldLeak")
abstract class BasePresenter<V : BaseView> : ViewModel(), LifecycleObserver {

    private var view: V? = null
    private var lifecycle: Lifecycle? = null

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun bind(v: V, lifecycle: Lifecycle) {
        view = v
        this.lifecycle = lifecycle
        this.lifecycle!!.addObserver(this)
    }

    fun getView() = view

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        view = null
        lifecycle = null
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    protected fun Disposable.toAutoDisposable() {
        disposable.add(this)
    }
}