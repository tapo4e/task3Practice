package com.example.mbanking.util

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy")
    return formatter.format(Date(millis))
}

@SuppressLint("SimpleDateFormat")
fun convertDateToMilliseconds(dateString: String): Long {
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    val date = sdf.parse(dateString)
    return date.time
}