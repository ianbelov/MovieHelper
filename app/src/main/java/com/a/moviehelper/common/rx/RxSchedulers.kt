package com.a.moviehelper.common.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RxSchedulers @Inject constructor() {

    fun computation(): Scheduler = Schedulers.computation()
    fun io(): Scheduler = Schedulers.io()
    fun new(): Scheduler = Schedulers.newThread()
    fun ui(): Scheduler = AndroidSchedulers.mainThread()

}