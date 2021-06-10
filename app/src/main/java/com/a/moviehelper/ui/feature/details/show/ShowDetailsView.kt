package com.a.moviehelper.ui.feature.details.show

import com.a.moviehelper.common.base.BaseView
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.core.network.movies.ShowModel

interface ShowDetailsView: BaseView {
    fun setDetails(model: ShowModel)
}