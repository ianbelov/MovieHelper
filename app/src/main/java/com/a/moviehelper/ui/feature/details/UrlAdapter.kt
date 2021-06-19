package com.a.moviehelper.ui.feature.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.databinding.ItemProviderUrlBinding

class UrlAdapter constructor(
    private val imageLoader: CoilImageLoader
) : RecyclerView.Adapter<UrlAdapter.ViewHolder>() {

    private var movies: ArrayList<Pair<String, String>> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemProviderUrlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], imageLoader)
    }

    fun addData(movieList: List<Pair<String, String>>) {
        movies.addAll(movieList)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemProviderUrlBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<String, String>, imageLoader: CoilImageLoader) {
            binding.run {
                imageLoader.load( item.first ,imageView2)
                urlTextView.setText(item.second)
            }
        }
    }


}