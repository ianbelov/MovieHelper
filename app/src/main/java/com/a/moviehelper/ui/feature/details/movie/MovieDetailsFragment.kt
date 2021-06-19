package com.a.moviehelper.ui.feature.details.movie

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.common.imageloading.IImageLoader
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.databinding.FragmentMovieDetailsBinding
import com.a.moviehelper.ui.feature.details.UrlAdapter
import com.bumptech.glide.Glide
import javax.inject.Inject

class MovieDetailsFragment :
    BaseFragment<MovieDetailsView, MovieDetailsPresenter>(R.layout.fragment_movie_details),
    MovieDetailsView {
    private lateinit var adapter: UrlAdapter
    private val binding by viewBinding(FragmentMovieDetailsBinding::bind)
    @Inject
    lateinit var imageLoader: CoilImageLoader
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        presenter.getMovieDetails(requireArguments().getParcelable(MOVIE_DETAILS_INPUT_MODEL))
    }

    private fun initAdapter() {
        adapter = UrlAdapter(
            imageLoader = imageLoader
        )
        binding.urlRecyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MovieDetailsFragment.adapter
        }
    }

    override fun setProviders(providers: List<Pair<String, String>>) {
        adapter.addData(providers)
    }

    override fun setDetails(model: MovieModel) {
        binding.movieDetailsFavoriteButton.setOnClickListener { presenter.onAddClicked(model.id.toString()) }
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

    override fun setAddButton() {
        Log.d("button", "add")
        binding.movieDetailsFavoriteButton.text = "Add to favorite"
        binding.movieDetailsFavoriteButton.backgroundTintList =
            ColorStateList.valueOf(resources.getColor(R.color.purple_500))
        binding.movieDetailsFavoriteButton.visibility = View.VISIBLE
    }

    override fun setRemoveButton() {
        Log.d("button", "remove")
        binding.movieDetailsFavoriteButton.text = "Delete from favorites"
        binding.movieDetailsFavoriteButton.backgroundTintList =
            ColorStateList.valueOf(resources.getColor(R.color.design_default_color_error))
        binding.movieDetailsFavoriteButton.visibility = View.VISIBLE
    }
}