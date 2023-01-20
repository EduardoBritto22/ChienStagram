package com.exalt.core.ui.extensions

import android.view.View

fun View.handleVisibility(isDisplayed: Boolean) {
    this.visibility =
        if (isDisplayed) {
            View.VISIBLE
        } else {
            View.GONE
        }
}
