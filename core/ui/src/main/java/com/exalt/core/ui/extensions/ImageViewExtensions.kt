package com.exalt.core.ui.extensions

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


fun ImageView.loadImage(url: String){

    val drawable = CircularProgressDrawable(this.context)
    drawable.start()

    Glide.with(this.context)
        .load(url)
        .centerInside()
        .placeholder(drawable)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}


fun ImageView.loadUserImage(userImageUrl: String) {
    val drawable = CircularProgressDrawable(this.context)
    drawable.start()

    Glide.with(this.context)
        .load(userImageUrl)
        .circleCrop()
        .placeholder(drawable)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}
