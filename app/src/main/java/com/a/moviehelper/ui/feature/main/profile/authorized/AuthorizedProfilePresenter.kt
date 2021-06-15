package com.godeltech.pokedex.ui.features.main.profile.authorized

import android.net.Uri
import com.a.moviehelper.common.base.BasePresenter
import javax.inject.Inject

class AuthorizedProfilePresenter @Inject constructor(
//    private val loginRepository: LoginRepository,
//    private val pokedexRepository: PokedexRepository,
//    private val schedulers: RxSchedulers,
//    private val navigator: IMainNavigator,
//    private val converter: PokemonsConverter
) : BasePresenter<AuthorizedProfileView>() {

//    private var catchedPokemonItems: List<PokemonItem> = listOf()

    fun onViewCreated() {
        showUserContent()
    }

    fun onHiddenChange(hidden: Boolean) {
//        if (!hidden) {
//            pokedexRepository.getCatchedPokemons()
//                .map {
//                    converter.filterCatchedPokemons(
//                        converter.mapPokemonsResponseToPokemonItems(it.pokemons),
//                        it.ids
//                    )
//                }
//                .subscribeOn(schedulers.io())
//                .observeOn(schedulers.ui())
//                .subscribeBy(onSuccess = { it ->
//                    if (catchedPokemonItems.map { it.id } != it) {
//                        getView()?.showProgressBar()
//                        catchedPokemonItems = it
//                        getView()?.showCatchedPokemons(it)
//                        getView()?.hideProgressBar()
//                    }
//                }, onError = {
//                })
//                .toAutoDisposable()
        }
    }

    fun updateProfileImage(image: Uri?) {
//        image?.let {
//            loginRepository.uploadImageToFirebase(it)
//                .subscribeOn(schedulers.io())
//                .observeOn(schedulers.ui())
//                .doOnSubscribe { getView()?.showProgressBarForImage() }
//                .doFinally { getView()?.hideProgressBarForImage() }
//                .subscribeBy(onSuccess = {
//                    getView()?.updateUserImage(it.image.toString())
//                }, onError = {
//                    Log.d("sendImageToFirebase", it.message)
//                })
//                .toAutoDisposable()
//        }
    }

    fun onLogOutClicked() {
//        loginRepository.signOut()
//            .subscribeOn(schedulers.io())
//            .observeOn(schedulers.ui())
//            .doOnSubscribe { getView()?.showProgressBar() }
//            .doFinally { getView()?.hideProgressBar() }
//            .subscribeBy(onComplete = {
//                navigator.navigateToMain()
//            }, onError = {
//                Log.d("onLogOutClicked error", it.message)
//            })
//            .toAutoDisposable()
    }

    fun onPokemonClicked(id: String) {
//        navigator.navigateToDetails(DetailsInputModel.Pokemon(id))
    }

    fun onPokeballClicked(id: String, isCatched: Boolean) {
//        var result: List<String> = catchedPokemonItems.map { it.id }
//        result = if (!isCatched) {
//            result.toMutableSet().plus(id).toList()
//        } else {
//            result.toMutableSet().minus(id).toList()
//        }
//        pokedexRepository.updateCatchedPokemons(result)
//            .subscribeOn(schedulers.io())
//            .observeOn(schedulers.ui())
//            .doOnSubscribe { getView()?.showProgressBar() }
//            .doFinally { getView()?.hideProgressBar() }
//            .subscribeBy(onSuccess = {
//                catchedPokemonItems = catchedPokemonItems.filter { it.id != id }
//                getView()?.showCatchedPokemons(catchedPokemonItems)
//            }, onError = {
//                Log.d("onPokeballClick", it.message)
//            })
//            .toAutoDisposable()
    }

    private fun showUserContent() {
//        Single.zip(
//            loginRepository.getUser().subscribeOn(schedulers.io()).observeOn(schedulers.ui()),
//            pokedexRepository.getCatchedPokemons().subscribeOn(schedulers.io()).observeOn(schedulers.ui()),
//            { profileModel: ProfileModel, profilePokemons: PokemonsWithCatchedIdsModel ->
//                Pair(profileModel, profilePokemons)
//            })
//            .map {
//                ProfileModelWithCatchedPokemons(
//                    it.first,
//                    converter.filterCatchedPokemons(
//                        converter.mapPokemonsResponseToPokemonItems(it.second.pokemons),
//                        it.second.ids
//                    )
//                )
//            }
//            .subscribeOn(schedulers.io())
//            .observeOn(schedulers.ui())
//            .doOnSubscribe { getView()?.showProgressBar() }
//            .doFinally { getView()?.hideProgressBar() }
//            .subscribeBy(onSuccess = {
//                catchedPokemonItems = it.pokemons
//                updateViews(it)
//            }, onError = {
//                getView()?.hideProgressBar()
//            })
//            .toAutoDisposable()
    }

//    private fun updateViews(model: ProfileModelWithCatchedPokemons) {
//        getView()?.showUser(model.profileModel.name, model.profileModel.email, model.profileModel.image)
//        getView()?.showCatchedPokemons(model.pokemons)
//        if (model.profileModel.image == Uri.EMPTY) {
//            getView()?.defaultImage()
//        }
//    }
