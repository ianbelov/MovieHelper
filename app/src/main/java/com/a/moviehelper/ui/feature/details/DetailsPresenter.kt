package com.a.moviehelper.ui.feature.details

import com.a.moviehelper.common.base.BasePresenter
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private var navigator: IDetailNavigator) :
    BasePresenter<DetailsView>() {

    fun onViewCreated(inputModel: DetailsInputModel?) {
        navigator.initFlow(inputModel)
    }
}