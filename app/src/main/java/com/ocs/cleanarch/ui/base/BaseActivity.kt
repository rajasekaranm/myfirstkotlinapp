package com.ocs.cleanarch.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.os.Build
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ocs.cleanarch.R

import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created on 28-Dec-17.
 */

open class BaseActivity : AppCompatActivity(), IBaseView, BaseFragment.Callback {
    override fun getBaseActivity(): BaseActivity {
        return this;
    }

    override fun isNetworkConnected(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatusBarHeight(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(resId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(resId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideKeyboard() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideKeyboard(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAlertWithPositiveButton(style: Int, msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun getListener(glideListener: GlideListener): RequestListener<Drawable>? {
        return object : RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                glideListener.onImageFailed()
                return false
            }

            override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                glideListener.onImageLoaded(resource)
                return false
            }
        }
    }

    override fun loadImage(imageView: ImageView, url: String, listener: GlideListener) {
        Glide.with(this).load(url).listener(getListener(listener)).into(imageView)
    }

    override fun loadImage(imageView: ImageView, url: String) {
        Glide.with(this).load(url).into(imageView)

    }

    override fun loadImage(imageView: CircleImageView, url: String, listener: GlideListener) {
        Glide.with(this).load(url).listener(getListener(listener)).into(imageView)

    }

    override fun loadImage(imageView: CircleImageView, url: String) {
        Glide.with(this).load(url).into(imageView)

    }

    override fun onGoogleAnalyticsForScreen(screenName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGoogleAnalyticsForEvent(category: String, name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun applyFontForMenuItem(item: MenuItem, typeface: Typeface, color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun applyColorForMenuItem(item: MenuItem, color: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addToolBar(toolbar: Toolbar, iconHome: Int, hideHomeIcon: Boolean) {
        setSupportActionBar(toolbar)
        if (!hideHomeIcon && supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

}
