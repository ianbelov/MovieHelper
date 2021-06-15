package com.a.moviehelper.core

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

const val IS_FIRST_START = "is_first_start"
const val SHARED_PREFS = "prefs"

class PokedexSharedPreferences @Inject constructor(val context: Context) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREFS, 0)

    fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun get(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }
    
}