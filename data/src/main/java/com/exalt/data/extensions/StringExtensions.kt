package com.exalt.data.extensions

import org.joda.time.*

fun String.convertToLocalDate(): LocalDate? {
    return try {
        DateTime.parse(this).toLocalDate()
    } catch (e: Exception) {
        null
    }
}

fun String.convertToDateTime(): DateTime {
    return try {
        DateTime.parse(this)
    } catch (e: Exception) {
        DateTime.now()
    }
}


fun String.convertToDuration(): Duration {
    return try {
        val dateTime = DateTime.parse(this)// We use DateTime first to avoid some exceptions in parsing UTC format
            .toLocalDateTime()
            .toDateTime(DateTimeZone.UTC)
        val now = LocalDateTime.now().toDateTime(DateTimeZone.UTC)

        Duration(dateTime, now)

    } catch (e: Exception) {
        Duration(0)
    }
}
