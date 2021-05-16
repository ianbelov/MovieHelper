package com.a.moviehelper.ui.feature.main.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.databinding.ItemMovieBinding

class MainMovieAdapter constructor(
    private val imageLoader: CoilImageLoader,
    private val onMovieClick: () -> Unit
) : RecyclerView.Adapter<MainMovieAdapter.ViewHolder>() {

    private var movies: ArrayList<MovieModel> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                .apply {
                    root.setOnClickListener { onMovieClick.invoke() }
                }
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], imageLoader)
    }

    fun addData(movieList: List<MovieModel>) {
        movies.addAll(movieList)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieModel, imageLoader: CoilImageLoader) {
            binding.run {
                title.text = item.title
                year.text = item.release_date
                imageLoader.load(NetworkUtils.IMG_BASE_URL + item.poster_path, image)
            }
        }
    }
}