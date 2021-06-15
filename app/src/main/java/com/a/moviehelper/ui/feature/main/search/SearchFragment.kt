package com.a.moviehelper.ui.feature.main.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.imageloading.CoilImageLoader
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.core.network.search.SearchModel
import com.a.moviehelper.databinding.FragmentSearchBinding
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
        binding.action.setOnClickListener { presenter.searchGenre(28) }
        binding.adventure.setOnClickListener { presenter.searchGenre(12) }
        binding.animation.setOnClickListener { presenter.searchGenre(16) }
        binding.comedy.setOnClickListener { presenter.searchGenre(35) }
        binding.crime.setOnClickListener { presenter.searchGenre(80) }
        binding.documentary.setOnClickListener { presenter.searchGenre(99) }
        binding.drama.setOnClickListener { presenter.searchGenre(18) }
        binding.family.setOnClickListener { presenter.searchGenre(10751) }
        binding.fantasy.setOnClickListener { presenter.searchGenre(14) }
        binding.history.setOnClickListener { presenter.searchGenre(36) }
        binding.horror.setOnClickListener { presenter.searchGenre(27) }
        binding.music.setOnClickListener { presenter.searchGenre(10402) }
        binding.mystery.setOnClickListener { presenter.searchGenre(9648) }
        binding.war.setOnClickListener { presenter.searchGenre(10752) }
        binding.western.setOnClickListener { presenter.searchGenre(37) }
        binding.romance.setOnClickListener { presenter.searchGenre(10749) }
        binding.science.setOnClickListener { presenter.searchGenre(878) }
        binding.thriller.setOnClickListener { presenter.searchGenre(53) }
    }

    private fun initAdapter() {
        Log.d("init", "happened")
        searchAdapter = SearchAdapter(imageLoader, {
            presenter.movieClicked(it)
        }, { presenter.showClicked(it) })
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
        binding.searchRecyclerView.visibility = View.VISIBLE
        binding.genresGroup.visibility = View.GONE
    }

    override fun hideSearch() {
        binding.searchRecyclerView.visibility = View.GONE
        binding.genresGroup.visibility = View.VISIBLE
    }

    override fun clearSearch() {
        searchAdapter.clear()
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}