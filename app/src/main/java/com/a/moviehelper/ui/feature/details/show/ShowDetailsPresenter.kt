package com.a.moviehelper.ui.feature.details.show

import android.util.Log
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.network.details.DetailsRepository
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsInputModel
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsView
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class ShowDetailsPresenter @Inject constructor(
    val repository: DetailsRepository,
    val schedulers: RxSchedulers
) : BasePresenter<ShowDetailsView>() {

    fun getMovieDetails(model: ShowDetailsInputModel?) =
        model?.let {
            repository.getShowDetails(it.id)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribeBy(onSuccess = {
                    getView()?.setDetails(it)
                    Log.d("details", it.toString())
                }, onError = {

                })
        }
}