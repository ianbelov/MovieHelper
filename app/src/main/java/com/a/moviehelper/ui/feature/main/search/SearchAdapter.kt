package com.a.moviehelper.ui.feature.main.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.core.network.search.SearchModel
import com.a.moviehelper.databinding.ItemMovieWideBinding

class SearchAdapter constructor(
    private val imageLoader: CoilImageLoader,
    private val onMovieClick: () -> Unit
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var movies: ArrayList<SearchModel> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemMovieWideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                .apply {
                    root.setOnClickListener { onMovieClick.invoke() }
                }
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], imageLoader)
    }

    fun setData(movieList: List<SearchModel>) {
        movies.clear()
        movies.addAll(movieList)
        Log.d("setData", movieList.toString())
        notifyDataSetChanged()
    }

    fun addData(movieList: List<SearchModel>) {
        movies.addAll(movieList)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemMovieWideBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchModel, imageLoader: CoilImageLoader) {
            binding.run {
                Log.d("item", item.name)
                name.text = item.name
                date.text = item.date
                description.text = item.descr
                imageLoader.load(NetworkUtils.IMG_BASE_URL + item.image, image)
            }
        }
    }

}