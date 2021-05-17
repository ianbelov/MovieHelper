package com.a.moviehelper.ui.feature.main.search

import com.a.moviehelper.common.base.BaseView
import com.a.moviehelper.core.network.search.SearchModel

interface SearchView : BaseView {
    fun setSearchResult(results: List<SearchModel>)
    fun addSearchResults(results: List<SearchModel>)
    fun hideSearch()
    fun clearSearch()
    fun showProgressBar()
    fun hideProgressBar()
}