package com.a.moviehelper.ui.feature.details.show

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.movies.ShowModel
import com.a.moviehelper.databinding.FragmentMovieDetailsBinding
import com.a.moviehelper.databinding.FragmentShowDetailsBinding
import com.a.moviehelper.ui.feature.details.UrlAdapter
import com.bumptech.glide.Glide
import javax.inject.Inject

class ShowDetailsFragment :
    BaseFragment<ShowDetailsView, ShowDetailsPresenter>(R.layout.fragment_show_details),
    ShowDetailsView {

    private lateinit var adapter: UrlAdapter
    private val binding by viewBinding(FragmentShowDetailsBinding::bind)
    @Inject
    lateinit var imageLoader: CoilImageLoader
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        presenter.getMovieDetails(requireArguments().getParcelable(SHOW_DETAILS_INPUT_MODEL))
    }

    private fun initAdapter() {
        adapter = UrlAdapter(
            imageLoader = imageLoader
        )
        binding.urlRecyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ShowDetailsFragment.adapter
        }
    }

    override fun setProviders(providers: List<Pair<String, String>>) {
        adapter.addData(providers)
    }

    override fun setDetails(model: ShowModel) {
        binding.showDetailsFavoriteButton.setOnClickListener { presenter.onAddClicked(model.id.toString()) }
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

    override fun setAddButton() {
        Log.d("button", "add")
        binding.showDetailsFavoriteButton.text = "Add to favorite"
        binding.showDetailsFavoriteButton.backgroundTintList =
            ColorStateList.valueOf(resources.getColor(R.color.purple_500))
        binding.showDetailsFavoriteButton.visibility = View.VISIBLE
    }

    override fun setRemoveButton() {
        Log.d("button", "remove")
        binding.showDetailsFavoriteButton.text = "Delete from favorites"
        binding.showDetailsFavoriteButton.backgroundTintList =
            ColorStateList.valueOf(resources.getColor(R.color.design_default_color_error))
        binding.showDetailsFavoriteButton.visibility = View.VISIBLE
    }
}