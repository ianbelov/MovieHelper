package com.a.moviehelper.core.sharedpref

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefProvider @Inject constructor (val context: Context){

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences("prefs", 0)

    fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun get(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun editor(): SharedPreferences.Editor{
        return  sharedPreferences.edit()
    }
}