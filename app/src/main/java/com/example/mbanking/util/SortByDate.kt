package com.example.mbanking.util

fun sortByDate(startDate: String, endDate: String, date: String): Boolean {
    return convertDateToMilliseconds(startDate) <= convertDateToMilliseconds(date) &&
            convertDateToMilliseconds(endDate) >= convertDateToMilliseconds(date)
}