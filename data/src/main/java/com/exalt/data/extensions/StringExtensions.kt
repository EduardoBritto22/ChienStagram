package com.exalt.data.extensions

import android.content.res.Resources
import com.exalt.data.R
import org.joda.time.DateTime
import org.joda.time.Duration
import org.joda.time.LocalDateTime
import org.joda.time.Years
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.util.*


fun String.verifyOwnerAge(birthDayDate: String): String {
    return try {

        // We use DateTime first to avoid some exceptions in parsing UTC format
        val dateTime = DateTime.parse(birthDayDate)
            .toLocalDateTime()
            .toDateTime()
        val now = LocalDateTime.now().toDateTime()

        if(Years.yearsBetween(dateTime, now).years >= 18){
            this
        } else {
            ""
        }

    } catch (e: Exception) {
        ""
    }
}



fun String.formatToBirthdayDate(): String {
    return try {
        val dateTime = DateTime.parse(this)
        val fmt: DateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy")
        fmt.print(dateTime)
    } catch (e: Exception) {
        ""
    }
}

fun String.formatToPostDate(locale: Locale): String {
    return try {
        val dateTime = DateTime.parse(this)
        val fmt: DateTimeFormatter = DateTimeFormat.mediumDateTime().withLocale(locale)
        fmt.print(dateTime)
    } catch (e: Exception) {
        ""
    }
}


fun String.formatToDuration(resources: Resources): String {
    return try {
        val dateTime = DateTime.parse(this)// We use DateTime first to avoid some exceptions in parsing UTC format
            .toLocalDateTime()
            .toDateTime()
        val now = LocalDateTime.now().toDateTime()

        val periodInMinutes = Duration(dateTime, now).standardMinutes
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