package com.a.moviehelper.ui.feature.details.movie

import android.util.Log
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.network.details.DetailsRepository
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(
    val repository: DetailsRepository,
    val schedulers: RxSchedulers
) : BasePresenter<MovieDetailsView>() {

    fun getMovieDetails(model: MovieDetailsInputModel?) =
        model?.let {
            repository.getMovieDetails(it.id)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribeBy(onSuccess = {
                    getView()?.setDetails(it)
                    Log.d("details", it.toString())
                }, onError = {

                })
        }
}