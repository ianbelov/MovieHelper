package com.a.moviehelper.common.viewbinding

import android.util.Log
import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(noinline bindFunction: (View) -> T) =
    FragmentViewBindingDelegate(this, bindFunction)

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val fragment: Fragment,
    private val bindFunction: (View) -> T
) : ReadOnlyProperty<Fragment, T>, LifecycleObserver {
    private var binding: T? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        binding = null
        fragment.viewLifecycleOwner.lifecycle.removeObserver(this)
    }

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        if (binding == null) {
            binding = bindFunction.invoke(thisRef.requireView())
            fragment.viewLifecycleOwner.lifecycle.addObserver(this)
        }
        return binding!!
    }
}