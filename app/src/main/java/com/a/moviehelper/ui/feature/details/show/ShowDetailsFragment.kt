package com.a.moviehelper.ui.feature.details.show

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a.moviehelper.R
import com.a.moviehelper.common.base.BaseFragment
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsPresenter
import com.a.moviehelper.ui.feature.details.movie.MovieDetailsView

class ShowDetailsFragment :
    BaseFragment<ShowDetailsView, ShowDetailsPresenter>(R.layout.fragment_show_details),
    ShowDetailsView