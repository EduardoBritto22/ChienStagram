package com.exalt.core.ui.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.exalt.core.ui.R


fun ImageView.loadImage(url: String){

    Glide.with(this.context)
        .load(url)
        .centerInside()
        .error(R.drawable.placeholder)
        .transition(withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}

fun ImageView.loadImageAndCircleCrop(userImageUrl: String) {

    Glide.with(this.context)
        .load(userImageUrl)
        .circleCrop()
        .error(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}
