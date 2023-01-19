package com.exalt.data.extensions

import android.content.res.Resources
import android.os.Build
import java.util.Locale

fun Resources.getLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.configuration.locales[0]
    } else {
        this.configuration.locale
    }
}