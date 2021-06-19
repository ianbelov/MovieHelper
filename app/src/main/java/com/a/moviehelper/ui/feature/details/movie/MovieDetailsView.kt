package com.a.moviehelper.ui.feature.details.movie

import com.a.moviehelper.common.base.BaseView
import com.a.moviehelper.core.network.movies.MovieModel

interface MovieDetailsView : BaseView {
    fun setDetails(model:MovieModel)
    fun setAddButton()
    fun setRemoveButton()
    fun setProviders(providers: List<Pair<String, String>>)
}