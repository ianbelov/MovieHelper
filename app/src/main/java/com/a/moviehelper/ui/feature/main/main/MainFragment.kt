package com.a.moviehelper.ui.feature.main.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.databinding.FragmentMainBinding
import com.a.moviehelper.ui.view.EndlessRecyclerViewScrollListener
import javax.inject.Inject

class MainFragment : BaseFragment<MainView, MainFragmentPresenter>(R.layout.fragment_main),
    MainView {

    @Inject
    lateinit var imageLoader: CoilImageLoader
    private val binding by viewBinding(FragmentMainBinding::bind)
    private lateinit var movieAdapter: MainMovieAdapter
    private lateinit var showAdapter: MainMovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        presenter.loadMovies()
        presenter.loadShows()
    }


    override fun showMovies(movies: List<MovieModel>) {
        movieAdapter.addData(movies)
        Log.d("shows", movies.toString())
    }

    override fun showShows(shows: List<MovieModel>) {
        showAdapter.addData(shows)
        Log.d("shows", shows.toString())
    }

    override fun showProgressBar() {
        binding.progressIndicatorView.visibility = View.VISIBLE
        binding.groups.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
        binding.progressIndicatorView.visibility = View.GONE
        binding.groups.visibility = View.VISIBLE
    }

    private fun initAdapters() {
        movieAdapter = MainMovieAdapter(
            imageLoader = imageLoader,
            onMovieClick = { },
        )
        showAdapter = MainMovieAdapter(
            imageLoader = imageLoader,
            onMovieClick = { },
        )
        binding.moviesRecyclerView.run {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false)
            adapter = movieAdapter
            addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(this.layoutManager!!) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    presenter.loadMovies()
                    Log.d("more", "load")
                }
            })
        }
        binding.showsRecyclerView.run {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false)
            adapter = showAdapter
        }
    }
}