package com.a.moviehelper.common.viewbinding

import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> AppCompatActivity.viewBinding(noinline bindFunction: (View) -> T) =
    ActivityViewBindingDelegate(this, bindFunction)

class ActivityViewBindingDelegate<T : ViewBinding>(
    private val activity: AppCompatActivity,
    private val bindFunction: (View) -> T
) : ReadOnlyProperty<AppCompatActivity, T>, LifecycleObserver {
    private var binding: T? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        binding = null
        activity.lifecycle.removeObserver(this)
    }

    @MainThread
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        if (binding == null) {
            binding = bindFunction.invoke(
                (thisRef.findViewById(android.R.id.content) as ViewGroup).getChildAt(0)
            )
            activity.lifecycle.addObserver(this)
        }
        return binding!!
    }
}