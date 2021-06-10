package com.a.moviehelper.ui.feature.details.movie

import android.os.Bundle
import android.view.View
import coil.Coil
import coil.request.ImageRequest
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.imageloading.IImageLoader
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.databinding.FragmentMovieDetailsBinding
import com.bumptech.glide.Glide
import javax.inject.Inject

class MovieDetailsFragment :
    BaseFragment<MovieDetailsView, MovieDetailsPresenter>(R.layout.fragment_movie_details),
    MovieDetailsView {
    private val binding by viewBinding(FragmentMovieDetailsBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMovieDetails(requireArguments().getParcelable(MOVIE_DETAILS_INPUT_MODEL))
    }

    override fun setDetails(model: MovieModel) {
        binding.movieDetailsProgressBar.setVisibility(View.GONE)
        binding.movieDetailsTitle.setVisibility(View.VISIBLE)
        binding.movieDetailsTitle.setText(model.title)
        binding.movieDetailsTag.setVisibility(View.VISIBLE)
        binding.movieDetailsTag.setText("")
        binding.movieDetailsDescription.setVisibility(View.VISIBLE)
        binding.movieDetailsDescription.setText(model.overview)
        binding.movieDetailsBudget.setText("Budget - " + model.budget + " $")
        binding.movieDetailsRevenue.setText("Revenue - " + model.revenue + " $")
        binding.movieDetailsRelease.setText("Release date: " + model.release_date)
        Glide.with(this)
            .load(NetworkUtils.IMG_BIG_SIZE_URL.plus(model.poster_path))
            .centerCrop()
            .into(binding.movieDetailsBackdrop)
        Glide.with(this)
            .load(NetworkUtils.IMG_BIG_SIZE_URL.plus(model.poster_path))
            .into(binding.movieDetailsPoster)
    }
}