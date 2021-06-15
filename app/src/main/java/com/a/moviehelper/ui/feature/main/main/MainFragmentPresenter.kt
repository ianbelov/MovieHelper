package com.a.moviehelper.ui.feature.main.main

import android.util.Log
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.network.movies.MainRepository
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.ui.feature.details.DetailsInputModel
import com.a.moviehelper.ui.feature.main.MainNavigator
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
                        it.imdb_id,
                        it.id,
                        "",
                        "",
                        it.poster_path,
                        it.backdrop_path,
                        it.first_air_date.toString(),
                        it.overview
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
        navigator.navigateToDetails(DetailsInputModel.Movie(id))
    }

    fun showClicked(id:String){
        navigator.navigateToDetails(DetailsInputModel.Show(id))
    }
}