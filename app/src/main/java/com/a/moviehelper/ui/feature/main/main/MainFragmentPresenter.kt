package com.a.moviehelper.ui.feature.main.main

import android.util.Log
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.network.movies.MainRepository
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.ui.feature.main.MainNavigator
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainFragmentPresenter @Inject constructor(
    val moviesRepository: MainRepository,
    val scheduler: RxSchedulers,
    val navigator: MainNavigator
) : BasePresenter<MainView>() {

    var moviePage = 1

    fun loadMovies() {
        moviesRepository.getMovies(moviePage)
            .subscribeOn(scheduler.io())
            .map { it.results }
            .observeOn(scheduler.ui())
            .doOnSubscribe { if (moviePage == 1) getView()?.showProgressBar() }
            .doFinally { getView()?.hideProgressBar() }
            .subscribe({ next ->
                getView()?.showMovies(next)
                moviePage++
            }, {
                Log.d("rx", it.message.toString())
            }).toAutoDisposable()
    }

    fun loadShows() {
        moviesRepository.getShows(1)
            .subscribeOn(scheduler.io())
            .map { it.results }
            .map { it ->
                it.map {
                    MovieModel(
                        it.name,
                        it.id,
                        it.poster_path,
                        it.first_air_date.toString(),
                        ""
                    )
                }
            }
            .observeOn(scheduler.ui())
            .doOnSubscribe { getView()?.showProgressBar() }
            .doFinally { getView()?.hideProgressBar() }
            .subscribe({ next ->
                getView()?.showShows(next)
            }, {
                Log.d("rx", it.message.toString())
            }).toAutoDisposable()
    }

    fun movieClicked(id:String){
        navigator.navigateToDetails()
    }
}