package com.example.mbanking.util

import android.icu.text.SimpleDateFormat

fun SortByDate(startDate:String,endDate:String,date:String):Boolean{
   return convertDateToMilliseconds(startDate)<=convertDateToMilliseconds(date) &&
    convertDateToMilliseconds(endDate)>= convertDateToMilliseconds(date)
}