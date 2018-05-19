package com.ocs.cleanarch.ui.home.presenter

import android.content.Context
import com.ocs.cleanarch.ui.base.BasePresenter
import com.ocs.cleanarch.ui.home.usecase.ICHome
import io.reactivex.disposables.CompositeDisposable


/**
 * Created on 19/5/18.
 */


class PHome<V : ICHome.IVHome>(context: Context) : BasePresenter<V>(), ICHome.IPHome<V> {

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