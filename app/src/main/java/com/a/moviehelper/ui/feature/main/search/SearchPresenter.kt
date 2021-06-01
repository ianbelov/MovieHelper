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
    private var showSearchPage = 1
    private var genreSearchPage = 1
    private var searchQuery = ""

    fun subscribeToSearchSubject() {
        searchSubject.debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(scheduler.ui())
            .doOnNext { searchQuery = it }
            .subscribeBy(onNext = {
                getView()?.clearSearch()
                search(it.trim())
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
    }

    fun onSearchQueryChanged(query: String) {
        movieSearchPage = 1
        showSearchPage = 1
        if (query.isEmpty()) {
            getView()?.hideSearch()
            searchQuery = ""
        } else
            searchSubject.onNext(query)
    }

    private fun search(query: String) {
        searchRepository.searchMovies(query, movieSearchPage)
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
            .doOnSubscribe { getView()?.showProgressBar() }
            .doFinally { getView()?.hideProgressBar() }
            .subscribeBy(onSuccess = {
                getView()?.addSearchResults(it)
                ++movieSearchPage
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()


        searchRepository.searchShows(query, movieSearchPage)
            .map { it ->
                it.results.map {
                    SearchModel(
                        it.name,
                        it.first_air_date.toString(),
                        "TV Series",
                        it.poster_path.toString()
                    )
                }
            }
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .doOnSubscribe { getView()?.showProgressBar() }
            .doFinally { getView()?.hideProgressBar() }
            .subscribeBy(onSuccess = {
                getView()?.addSearchResults(it)
                Log.d("add shows", "happened")
                ++showSearchPage
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
    }

    fun searchMore() {
        searchRepository.searchMovies(searchQuery, movieSearchPage)
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
                getView()?.addSearchResults(it)
                ++movieSearchPage
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
        searchRepository.searchShows(searchQuery, movieSearchPage)
            .map { it ->
                it.results.map {
                    SearchModel(
                        it.name,
                        it.first_air_date.toString(),
                        "TV Series",
                        it.poster_path.toString()
                    )
                }
            }
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribeBy(onSuccess = {
                getView()?.addSearchResults(it)
                Log.d("add shows", "happened")
                ++showSearchPage
            }, onError = { Log.d("rx", it.message.toString()) })
            .toAutoDisposable()
    }

    fun searchGenre(id: Int) = searchRepository.searchGenre(id, genreSearchPage)
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
        .doOnSubscribe { getView()?.showProgressBar() }
        .doFinally { getView()?.hideProgressBar() }
        .subscribeBy(onSuccess = {
            getView()?.addSearchResults(it)
            ++genreSearchPage
        }, onError = { Log.d("rx", it.message.toString()) })
        .toAutoDisposable()
}