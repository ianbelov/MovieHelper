package com.a.moviehelper.ui.feature.main.profile.authorized

import android.net.Uri
import android.os.Bundle
import android.view.View
import coil.ImageLoader
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.common.viewbinding.viewBinding
import com.a.moviehelper.databinding.FragmentAuthProfileBinding
import com.godeltech.pokedex.ui.features.main.profile.authorized.AuthorizedProfilePresenter
import com.godeltech.pokedex.ui.features.main.profile.authorized.AuthorizedProfileView
import javax.inject.Inject

const val INPUT_TYPE = "image/*"

class AuthorizedProfileFragment :
    BaseFragment<AuthorizedProfileView, AuthorizedProfilePresenter>(R.layout.fragment_auth_profile),
    AuthorizedProfileView {

//    @Inject
//    lateinit var imageLoader: ImageLoader
    private val binding by viewBinding(FragmentAuthProfileBinding::bind)
//    private val contentResult =
//        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
//            presenter.updateProfileImage(uri)
//        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initAdapter()
//        binding.toolbar.setOnEndButtonClickListener { presenter.onLogOutClicked() }
//        binding.addAvatarButton.setOnClickListener {
//            contentResult.launch(INPUT_TYPE)
//        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewCreated()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        presenter.onHiddenChange(hidden)
    }

    override fun showProgressBar() {
//        binding.progressIndicatorView.visibility = View.VISIBLE
//        binding.mainView.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
//        binding.progressIndicatorView.visibility = View.GONE
//        binding.mainView.visibility = View.VISIBLE
    }

    override fun showProgressBarForImage() {
//        binding.progressView.visibility = View.VISIBLE
    }

    override fun hideProgressBarForImage() {
//        binding.progressView.visibility = View.GONE
    }

    override fun showUser(name: String, email: String, image: Uri) {
//        binding.profileNameTextView.text = name
//        binding.profileEmailTextView.text = email
//        imageLoader.load(image.toString(), binding.imageView)
    }

    override fun updateUserImage(image: String) {
//        imageLoader.load(image, binding.imageView)
    }

    override fun defaultImage() {
//        binding.imageView.setImageResource(R.drawable.ic_meowth)
    }

    private fun initAdapter() {
//        val pokedexAdapter = PokedexAdapter(
//            imageLoader = imageLoader,
//            onPokeballClick = { id, isCatched -> presenter.onPokeballClicked(id, isCatched) },
//            onPokemonClick = { presenter.onPokemonClicked(it) }
//        )
//        binding.recyclerView.run {
//            layoutManager = LinearLayoutManager(context)
//            adapter = pokedexAdapter
//        }
    }
}