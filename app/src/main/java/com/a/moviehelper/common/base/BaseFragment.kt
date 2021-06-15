package com.a.moviehelper.common.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import com.godeltech.pokedex.common.utils.getGenericClass
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : DaggerFragment {

    constructor() : super()

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory

    val presenter by lazy {
        ViewModelProvider(this, modelFactory).get(getGenericClass<P>(1))
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bind(this@BaseFragment as V, viewLifecycleOwner.lifecycle)
    }
}