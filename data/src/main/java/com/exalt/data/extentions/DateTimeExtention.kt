package com.exalt.data.extentions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun String.formatToBirthdayDate(): String {
    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    return try {
        formatter.format(parser.parse(this)!!)
    } catch (e: Exception) {
        ""
    }
}