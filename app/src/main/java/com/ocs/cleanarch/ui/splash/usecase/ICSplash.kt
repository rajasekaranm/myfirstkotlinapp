package com.ocs.cleanarch.ui.splash.usecase


import com.ocs.cleanarch.ui.base.IBasePresenter
import com.ocs.cleanarch.ui.base.IBaseView

/**
 * Created on 19/5/18.
 */

interface ICSplash {

    interface IVSplash : IBaseView {
        fun onNavigateToHome()
    }

    interface IPSplash<V : ICSplash.IVSplash> : IBasePresenter<V> {
        fun onNavigateToNextViewWithDelay()
    }
}