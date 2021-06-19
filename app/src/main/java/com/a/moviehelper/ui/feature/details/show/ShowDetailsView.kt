package com.a.moviehelper.ui.feature.details.show

import com.a.moviehelper.common.base.BaseView
import com.a.moviehelper.core.network.movies.ShowModel

interface ShowDetailsView: BaseView {
    fun setDetails(model: ShowModel)
    fun setAddButton()
    fun setRemoveButton()
    fun setProviders(providers: List<Pair<String, String>>)
}