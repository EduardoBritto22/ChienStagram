package com.exalt.core.ui.extensions

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


fun ImageView.loadImage(url: String){

    val drawable = getCircularProgressDrawable()

    Glide.with(this.context)
        .load(url)
        .centerInside()
        .placeholder(drawable)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}

fun ImageView.loadUserImage(userImageUrl: String) {

    Glide.with(this.context)
        .load(userImageUrl)
        .circleCrop()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}


private fun ImageView.getCircularProgressDrawable(): CircularProgressDrawable {
    val drawable = CircularProgressDrawable(this.context)
    drawable.strokeWidth = 5f
    drawable.centerRadius = 30f
    drawable.start()
    return drawable
}
