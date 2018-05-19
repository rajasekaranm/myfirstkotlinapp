package com.ocs.cleanarch.ui.base

import android.app.Activity

/**
 * Created on 26-Dec-17.
 */

interface IBasePresenter<V : IBaseView> {

    fun isViewAttached(): Boolean

    fun onAttach(mvpView: V)

    fun onDetach()

    fun getMvpView() : V

    fun getDeviceHeight(activity: Activity): Int

    fun getDeviceWidth(activity: Activity): Int

}
