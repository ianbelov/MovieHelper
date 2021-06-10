package com.a.moviehelper.ui.feature.details.show

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.core.network.movies.ShowModel
import com.a.moviehelper.databinding.FragmentMovieDetailsBinding
import com.a.moviehelper.databinding.FragmentShowDetailsBinding
import com.a.moviehelper.ui.feature.details.movie.MOVIE_DETAILS_INPUT_MODEL
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsPresenter
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsView
import com.bumptech.glide.Glide

class ShowDetailsFragment :
    BaseFragment<ShowDetailsView, ShowDetailsPresenter>(R.layout.fragment_show_details),
    ShowDetailsView {

    private val binding by viewBinding(FragmentShowDetailsBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getMovieDetails(requireArguments().getParcelable(SHOW_DETAILS_INPUT_MODEL))
    }

    override fun setDetails(model: ShowModel) {
        binding.showDetailsProgressBar.setVisibility(View.GONE)
        binding.showDetailsTitle.setVisibility(View.VISIBLE)
        binding.showDetailsTitle.setText(model.name)
        binding.showDetailsTag.setVisibility(View.VISIBLE)
        binding.showDetailsTag.setText("")
        binding.showDetailsDescription.setVisibility(View.VISIBLE)
        binding.showDetailsDescription.setText(model.overview)
        binding.showDetailsRelease.setText("First air date: " + model.first_air_date)
        Glide.with(this)
            .load(NetworkUtils.IMG_BIG_SIZE_URL.plus(model.poster_path))
            .centerCrop()
            .into(binding.showDetailsBackdrop)
        Glide.with(this)
            .load(NetworkUtils.IMG_BIG_SIZE_URL.plus(model.poster_path))
            .into(binding.showDetailsPoster)
    }
}