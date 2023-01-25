package com.exalt.core.ui.extensions

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter


fun LocalDate?.formatToBirthDateString(): String{
    return try {
        val fmt: DateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy")
        fmt.print(this)
    } catch (e: Exception) {
        ""
    }
}
