package com.a.moviehelper.ui.feature.details

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.a.moviehelper.R
import com.a.moviehelper.common.navigation.submitNavigation
import com.a.moviehelper.common.rx.RxActivityProvider
import com.a.moviehelper.ui.feature.details.movie.MOVIE_DETAILS_INPUT_MODEL
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsInputModel
import com.a.moviehelper.ui.feature.details.show.SHOW_DETAILS_INPUT_MODEL
import com.a.moviehelper.ui.feature.details.show.ShowDetailsInputModel
import javax.inject.Inject

class DetailNavigator @Inject constructor(private val activityProvider: RxActivityProvider) :
    IDetailNavigator {

    override fun initFlow(inputModel: DetailsInputModel?) {
        activityProvider.submitNavigation {
            val graph = this.navInflater.inflate(R.navigation.detail_navigation)
            var arg: Bundle = bundleOf()
            when (inputModel) {
                is DetailsInputModel.Movie
                -> {
                    Log.d("details", "s")
                    graph.startDestination = R.id.detail_movie
                    arg =
                        bundleOf(MOVIE_DETAILS_INPUT_MODEL to MovieDetailsInputModel(inputModel.id))
                }
                is DetailsInputModel.Show -> {
                    graph.startDestination = R.id.detail_show
                    arg = bundleOf(SHOW_DETAILS_INPUT_MODEL to ShowDetailsInputModel(inputModel.id))
                }
            }
            setGraph(graph, arg)
        }
    }

    override fun navigateToMovieDetail(id: Bundle) {
        activityProvider.submitNavigation {
            navigate(R.id.detail_movie, id)
        }
    }

    override fun navigateToShowDetail(id: Bundle) {
        activityProvider.submitNavigation {
            navigate(R.id.detail_show, id)
        }
    }

    override fun navigateBack() {
        activityProvider.submitNavigation {
            popBackStack()
        }
    }

    override fun navigateBackFromDetails() {
        activityProvider.submitActivity { finish() }
    }

}

interface IDetailNavigator {
    fun initFlow(inputModel: DetailsInputModel?)
    fun navigateToMovieDetail(id: Bundle)
    fun navigateToShowDetail(id: Bundle)
    fun navigateBackFromDetails() {}
    fun navigateBack() {}
}