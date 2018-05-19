package com.ocs.cleanarch.ui.splash.presenter

import io.reactivex.disposables.CompositeDisposable

import android.content.Context

import com.ocs.cleanarch.ui.base.BasePresenter
import com.ocs.cleanarch.ui.splash.usecase.ICSplash
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import java.util.concurrent.TimeUnit


/**
 * Created on 19/5/18.
 */


class PSplash<V : ICSplash.IVSplash>(context: Context) : BasePresenter<V>(), ICSplash.IPSplash<V> {
    override fun onNavigateToNextViewWithDelay() {
        val disposable = Completable
                .timer(3, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(Action {
                    getMvpView().onNavigateToHome()
                })



        compositeDisposable.add(disposable)
    }

    private val compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun onDetach() {
        super.onDetach()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()

    }

}