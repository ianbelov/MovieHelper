package com.a.moviehelper.ui.feature.details.show

import android.util.Log
import com.a.moviehelper.common.base.BasePresenter
import com.a.moviehelper.common.rx.RxSchedulers
import com.a.moviehelper.core.network.details.DetailsRepository
import com.a.moviehelper.core.network.search.SearchRepository
import com.a.moviehelper.ui.feature.details.movie.MOVIE_QUERY
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsInputModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

const val SHOW_QUERY = "saved_shows"

class ShowDetailsPresenter @Inject constructor(
    val repository: DetailsRepository,
    val searchRepository: SearchRepository,
    val schedulers: RxSchedulers,
    val db: FirebaseDatabase,
    val auth: FirebaseAuth
) : BasePresenter<ShowDetailsView>() {

    fun getMovieDetails(model: ShowDetailsInputModel?) {
        model?.let {
            repository.getShowDetails(it.id)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribeBy(onSuccess = {
                    getProviders(it.id.toString())
                    getView()?.setDetails(it)
                    Log.d("details", it.toString())
                }, onError = {

                })
            getCatchedPokemonsIds()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribeBy(onSuccess = {
                    if (!(model.id in it)) getView()?.setAddButton() else getView()?.setRemoveButton()
                }, onError = {
                    Log.d("error", it.message.toString())
                })
        }

    }

    fun getProviders(id: String?) {
        id?.let {
            searchRepository.searchProviders("tmdb", "tv/"+it).subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribeBy(onSuccess = {
                    getView()?.setProviders(it.collection.locations.map { Pair(it.icon, it.url) })
                }, onError = {
                    Log.d("PROVIDERS", it.toString())
                })
        }
    }

    fun onAddClicked(id: String) {
        getCatchedPokemonsIds()
            .flatMap {
                val ids = it
                var isRemoved = true
                if (it.contains(id)) {
                    ids.remove(id)
                    isRemoved = false
                } else ids.add(id)
                updateCatchedPokemons(ids, isRemoved)
                    .subscribeOn(schedulers.io()).observeOn(schedulers.ui())
            }
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribeBy(onSuccess = {
                if (!it) {
                    getView()?.setAddButton()
                } else {
                    getView()?.setRemoveButton()
                }
            }, onError = {
                Log.d("error", it.message.toString())
            })
    }

    fun updateCatchedPokemons(movies: List<String>, isAdded: Boolean): Single<Boolean> =
        Single.create {
            db.reference.child(auth.currentUser!!.uid).child(SHOW_QUERY).setValue(movies)
                .addOnSuccessListener { _ ->
                    it.onSuccess(isAdded)
                }
                .addOnFailureListener { error ->
                    it.onError(error)
                }
        }

    fun getCatchedPokemonsIds(): Single<MutableList<String>> {
        if (auth.currentUser != null) {
            return Single.create {
                db.reference.child(auth.currentUser!!.uid).child(SHOW_QUERY)
                    .get()
                    .addOnSuccessListener { data ->
                        if (data.value == null) {
                            it.onSuccess(mutableListOf())
                        } else
                            it.onSuccess(data.value as MutableList<String>)
                    }
                    .addOnFailureListener { error ->
                        it.onError(error)
                    }
            }
        } else {
            return Single.just(mutableListOf())
        }
    }
}