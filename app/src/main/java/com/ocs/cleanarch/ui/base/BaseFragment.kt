package com.ocs.cleanarch.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.view.View
import android.widget.ImageView

import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created on 29-Dec-17.
 */

class BaseFragment : Fragment(), IBaseView {
    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    private lateinit var mActivity: BaseActivity
    private val dialogQuitAlert: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.mActivity = activity!!
            activity.onFragmentAttached()
        }
    }

    override fun initUI() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError(message: String) {
        mActivity.onError(message)
    }

    override fun onError(@StringRes resId: Int) {
        mActivity.onError(resId)
    }

    override fun showMessage(message: String) {
        mActivity.showMessage(message)
    }

    override fun showMessage(@StringRes resId: Int) {
        mActivity.showMessage(resId)
    }

    override fun isNetworkConnected(): Boolean {
        return mActivity.isNetworkConnected()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun hideKeyboard() {
        mActivity.hideKeyboard()
    }

    override fun hideKeyboard(view: View) {
        mActivity.hideKeyboard(view)
    }

    override fun getStatusBarHeight(): Int {
        return getBaseActivity().getStatusBarHeight()
    }

    override fun loadImage(imageView: ImageView, url: String, listener: GlideListener) {
        getBaseActivity().loadImage(imageView, url, listener)

    }

    override fun loadImage(imageView: ImageView, url: String) {
        getBaseActivity().loadImage(imageView, url)
    }

    override fun loadImage(imageView: CircleImageView, url: String, listener: GlideListener) {
        getBaseActivity().loadImage(imageView, url, listener)
    }

    override fun loadImage(imageView: CircleImageView, url: String) {
        getBaseActivity().loadImage(imageView, url)
    }


    override fun getBaseActivity(): BaseActivity {
        return mActivity
    }

    @TargetApi(Build.VERSION_CODES.M)
    protected fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    protected fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || getBaseActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }


    override fun showAlertWithPositiveButton(style: Int, msg: String) {
        getBaseActivity().showAlertWithPositiveButton(style, msg)
    }


    override fun onGoogleAnalyticsForScreen(screenName: String) {
        getBaseActivity().onGoogleAnalyticsForScreen(screenName)
    }

    override fun onGoogleAnalyticsForEvent(category: String, name: String) {
        getBaseActivity().onGoogleAnalyticsForEvent(category, name)
    }

    override fun applyFontForMenuItem(item: MenuItem, typeface: Typeface, color: Int) {
        getBaseActivity().applyFontForMenuItem(item, typeface, color)
    }

    override fun applyColorForMenuItem(item: MenuItem, color: Int) {
        getBaseActivity().applyColorForMenuItem(item, color)
    }
}
