package com.a.moviehelper.ui.feature.main.search

import android.util.Log
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.network.search.SearchModel
import com.a.moviehelper.core.network.search.SearchRepository
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchRepository: SearchRepository,
    private val scheduler: RxSchedulers
) :
    BasePresenter<SearchView>() {
    private var searchSubject = PublishSubject.create<String>()
    private var movieSearchPage = 1
    private var searchQuery = ""

    fun subscribeToSearchSubject() {
        Log.d("suscrobe", "next")
        searchSubject.debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(scheduler.ui())
            .doOnNext { searchQuery = it }
            .subscribeBy(onNext = {
                search(it.trim())
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
    }

    fun onSearchQueryChanged(query: String) {
        movieSearchPage = 1
        if (query.isEmpty()) {
            getView()?.hideSearch()
            searchQuery = ""
        } else
            searchSubject.onNext(query)
    }

    private fun search(query: String) {
        Log.d("search for ", query)
        searchRepository.search(query, movieSearchPage)
            .map { it ->
                Log.d("searchmap", it.results.toString())
                Log.d("searchmap page", it.page.toString())
                it.results.map {
                    SearchModel(
                        it.title,
                        it.release_date,
                        it.overview,
                        it.poster_path.toString()
                    )
                }
            }
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(onSuccess = {
                Log.d("onsuccess", it.toString())
                getView()?.setSearchResult(it)
                ++movieSearchPage
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
    }

    fun searchMore() {
        Log.d("search mor", "next")
        searchRepository.search(searchQuery, movieSearchPage)
            .map { it ->
                it.results.map {
                    SearchModel(
                        it.title,
                        it.release_date,
                        it.overview,
                        it.poster_path.toString()
                    )
                }
            }
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(onSuccess = {
                Log.d("more", "load")
                getView()?.addSearchResults(it)
                ++movieSearchPage
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
    }

}