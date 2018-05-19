package com.ocs.cleanarch.ui.base


import android.app.Activity
import android.util.DisplayMetrics

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
open class BasePresenter<V : IBaseView> : IBasePresenter<V> {


    override fun getMvpView(): V {
        return mvpView
    }


    private lateinit var mvpView: V
    var mvpViewAttached: Boolean = false

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
        mvpViewAttached = true

    }

    override fun onDetach() {
        mvpViewAttached = false
    }

    override fun isViewAttached(): Boolean {
        return mvpViewAttached
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }

    override fun getDeviceHeight(activity: Activity): Int {
        val metrices = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metrices)
        return metrices.heightPixels
    }

    override fun getDeviceWidth(activity: Activity): Int {
        val metrices = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metrices)
        return metrices.widthPixels
    }


    class ViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")
}
