package com.exalt.data.extensions

import org.joda.time.DateTime
import org.joda.time.Duration
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

fun String.formatToBirthdayDate(): String {
    return try {
        val dateTime = DateTime.parse(this)
        val fmt: DateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy")
        fmt.print(dateTime)
    } catch (e: Exception) {
        ""
    }
}


fun String.formatToDuration(): String {
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
            periodInMinutes >= minutesInYear -> "${periodInMinutes / minutesInYear} a"
            periodInMinutes >= minutesInWeek -> "${periodInMinutes / minutesInWeek} sem"
            periodInMinutes >= minutesInDay -> "${periodInMinutes / minutesInDay} j"
            periodInMinutes >= minutesInHour -> "${periodInMinutes / minutesInHour} h"
            periodInMinutes > 0 -> "$periodInMinutes min"
            periodInMinutes == 0L -> "now"
            else -> ""
        }
    } catch (e: Exception) {
        ""
    }

}