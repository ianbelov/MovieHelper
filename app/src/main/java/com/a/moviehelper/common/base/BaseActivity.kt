package com.a.moviehelper.common.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import com.a.moviehelper.common.utils.getGenericClass
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : DaggerAppCompatActivity{

    constructor() : super()

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory

    val presenter by lazy {
        ViewModelProvider(this, modelFactory).get(getGenericClass<P>(1))
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bind(this as V, lifecycle)
    }
}
