package com.yap.core.binders

import android.graphics.Bitmap
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

object ImageBinding {
    @BindingAdapter("bitmapSrc")
    @JvmStatic
    fun setBitmapSrc(view: AppCompatImageView, bitmap: Bitmap?) {
        if (bitmap != null)
            view.setImageBitmap(bitmap)
    }

    @JvmStatic
    @BindingAdapter("app:srcDrawable")
    fun setImageViewResource(imageView: AppCompatImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

}
