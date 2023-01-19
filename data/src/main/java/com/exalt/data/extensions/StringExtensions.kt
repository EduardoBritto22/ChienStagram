package com.exalt.data.extensions

import com.exalt.domain.home.enums.Gender
import org.joda.time.*

fun String.formatToBirthdayDate(): LocalDate? {
    return try {
        DateTime.parse(this).toLocalDate()
    } catch (e: Exception) {
        null
    }
}

fun String.formatToPostDate(): DateTime {
    return try {
        DateTime.parse(this)
    } catch (e: Exception) {
        DateTime.now()
    }
}


fun String.formatToDuration(): Duration {
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


fun String?.asGender() = when (this) {
    null -> Gender.OTHER
    else -> Gender.values()
        .firstOrNull { gender -> gender.text == this }
        ?: Gender.OTHER
}
