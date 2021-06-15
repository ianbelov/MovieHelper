package com.godeltech.pokedex.common.utils

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import java.lang.reflect.ParameterizedType

fun <P> Fragment.getGenericClass(paramNumber: Int): Class<P> {
    return ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[paramNumber] as Class<P>)
}

fun <P> ComponentActivity.getGenericClass(paramNumber: Int): Class<P> {
    return ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[paramNumber] as Class<P>)
}
