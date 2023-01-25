package com.exalt.core.ui.extensions

import android.content.res.Resources
import com.exalt.core.ui.R
import org.joda.time.Duration

fun Duration.formatToDuration(resources: Resources): String {
    return try {
        val periodInMinutes = this.standardMinutes
        val minutesInHour = 60
        val minutesInDay = 24 * minutesInHour
        val minutesInWeek = 7 * minutesInDay
        val minutesInYear = 365 * minutesInDay

        when {
            periodInMinutes >= minutesInYear -> resources.getString(R.string.text_duration_years, periodInMinutes / minutesInYear )
            periodInMinutes >= minutesInWeek -> resources.getString(R.string.text_duration_weeks, periodInMinutes / minutesInWeek )
            periodInMinutes >= minutesInDay -> resources.getString(R.string.text_duration_days, periodInMinutes / minutesInDay )
            periodInMinutes >= minutesInHour -> resources.getString(R.string.text_duration_hours, periodInMinutes / minutesInHour )
            periodInMinutes > 0 -> resources.getString(R.string.text_duration_minutes, periodInMinutes)
            periodInMinutes == 0L -> resources.getString(R.string.text_duration_now)
            else -> ""
        }
    } catch (e: Exception) {
        ""
    }

}