package com.godeltech.pokedex.ui.features.main.profile.authorized

import android.net.Uri
import com.a.moviehelper.common.base.BaseView

interface AuthorizedProfileView : BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showProgressBarForImage()
    fun hideProgressBarForImage()
    fun showUser(name: String, email: String, image: Uri)
    fun updateUserImage(image: String)
    fun defaultImage()
}