package com.godeltech.pokedex.core.firebase

import android.net.Uri

data class ProfileModel(
    val name: String,
    val email: String,
    val image: Uri
)