package com.ocs.cleanarch.ui.base

import android.graphics.Typeface
import android.support.annotation.StringRes
import android.view.MenuItem
import android.view.View
import android.widget.ImageView

import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created on 26-Dec-17.
 */

interface IBaseView {

    fun getBaseActivity(): BaseActivity

    fun isNetworkConnected(): Boolean

    fun getStatusBarHeight(): Int

    fun initUI()

    fun showLoading()

    fun hideLoading()

    fun onError(@StringRes resId: Int)

    fun onError(message: String)

    fun showMessage(message: String)

    fun showMessage(@StringRes resId: Int)

    fun hideKeyboard()

    fun hideKeyboard(view: View) : Unit

    fun showAlertWithPositiveButton(style: Int, msg: String)

    fun loadImage(imageView: ImageView, url: String, listener: GlideListener)

    fun loadImage(imageView: ImageView, url: String)

    fun loadImage(imageView: CircleImageView, url: String, listener: GlideListener)

    fun loadImage(imageView: CircleImageView, url: String)

    fun onGoogleAnalyticsForScreen(screenName: String)

    fun onGoogleAnalyticsForEvent(category: String, name: String)

    fun applyFontForMenuItem(item: MenuItem, typeface: Typeface, color: Int)

    fun applyColorForMenuItem(item: MenuItem, color: Int)
}
