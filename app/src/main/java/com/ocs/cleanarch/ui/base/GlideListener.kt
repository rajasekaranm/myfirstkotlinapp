package com.ocs.cleanarch.ui.base

import android.graphics.drawable.Drawable

/**
 * Created on 02-Feb-18.
 */

interface GlideListener {
    fun onImageLoaded(resource: Drawable)
    fun onImageFailed()
}
