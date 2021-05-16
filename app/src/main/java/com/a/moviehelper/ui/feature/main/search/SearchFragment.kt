package com.a.moviehelper.ui.feature.main.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.movies.MovieModel
import com.a.moviehelper.core.network.search.SearchModel
import com.a.moviehelper.databinding.FragmentSearchBinding
import com.a.moviehelper.ui.feature.main.main.MainMovieAdapter
import com.a.moviehelper.ui.view.EndlessRecyclerViewScrollListener
import javax.inject.Inject


class SearchFragment : BaseFragment<SearchView, SearchPresenter>(R.layout.fragment_search),
    SearchView {

    @Inject
    lateinit var imageLoader: CoilImageLoader

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private lateinit var searchAdapter: SearchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        presenter.subscribeToSearchSubject()
        binding.searchBar.searchEditText.addTextChangedListener {
            Log.d("listemer", "happened")
            presenter.onSearchQueryChanged(
                it.toString()
            )
        }
    }

    private fun initAdapter() {
        Log.d("init", "happened")
        searchAdapter = SearchAdapter(imageLoader, {})
        binding.searchRecyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = searchAdapter
            addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(this.layoutManager!!) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    presenter.searchMore()
                }
            })
        }
    }

    override fun setSearchResult(results: List<SearchModel>) {
        searchAdapter.setData(results)
        Log.d("set", results.toString())
        binding.searchRecyclerView.visibility = View.VISIBLE
        binding.genresGroup.visibility = View.GONE
    }

    override fun addSearchResults(results: List<SearchModel>) {
        Log.d("add", "happened")
        searchAdapter.addData(results)
    }

    override fun hideSearch() {
        binding.searchRecyclerView.visibility = View.GONE
        binding.genresGroup.visibility = View.VISIBLE
    }
}