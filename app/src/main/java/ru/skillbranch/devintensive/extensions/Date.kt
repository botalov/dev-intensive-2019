package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy") : String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}


fun Date.add(value: Int, units: TimeUnit = TimeUnit.SECONDS): Date {
    var time = this.time

    time += when(units) {
        TimeUnit.SECONDS -> value * SECOND
        TimeUnit.MINUTES -> value * MINUTE
        TimeUnit.HOURS -> value * HOUR
        TimeUnit.DAYS -> value * DAY
        else -> throw IllegalStateException("invalid units")
    }
    this.time = time
    return this
}

