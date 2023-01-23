package com.exalt.core.domain.home.extensions

import org.joda.time.DateTimeZone
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime
import org.joda.time.Years

fun LocalDate?.getAgeInYears(): Int {

    var age = 0
    this?.let {
        val now = LocalDateTime.now(DateTimeZone.UTC).toLocalDate()
        age = Years.yearsBetween(this, now).years
    }

    return maxOf(age,0) //negative years won't be considered
}


