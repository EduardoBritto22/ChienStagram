package com.exalt.core.ui.extensions

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.util.*

fun DateTime.formatToLocalMediumDateTimeString(locale: Locale): String {
    return try {
        val fmt: DateTimeFormatter = DateTimeFormat.mediumDateTime().withLocale(locale)
        fmt.print(this)
    } catch (e: Exception) {
        ""
    }
}

