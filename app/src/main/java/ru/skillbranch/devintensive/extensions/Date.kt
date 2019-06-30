package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

private const val SECOND = 1000L
private const val MINUTE = 60 * SECOND
private const val HOUR = 60 * MINUTE
private const val DAY = 24 * HOUR

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


fun Date.humanizeDiff() : String{
    val time = this.time
    val currentTime = Date().time

    val different = ((time - currentTime) / 1000).toInt() //SEC
    val differentMinutes: Int = abs(different / 60)  //MINUTES
    val differentHours: Int = abs(differentMinutes / 60) //HOURS
    val differentDays: Int = abs(differentHours / 24)  //DAYS

    val res = if(different <= 0) {
        when(abs(different)) {
            in 0..1 -> "только что"
            in 1..45 -> "несколько секунд назад"
            in 45..75 -> "минуту назад"
            else ->{
                when(differentMinutes) {
                    1 -> "минуту назад"
                    in 2..45 -> {
                        if(differentMinutes%10 in 2..4) {
                            if(differentMinutes in 11..19) {
                                "$differentMinutes минут назад"
                            }
                            else {
                                "$differentMinutes минуты назад"
                            }
                        }
                        else if(differentMinutes%10 == 1 && differentMinutes != 11) {
                            "$differentMinutes минуту назад"
                        }
                        else{
                            "$differentMinutes минут назад"
                        }
                    }
                    in 45..75 -> "час назад"
                    else-> {
                        when(differentHours) {
                            1 ->  "час назад"
                            in 2..22 -> {
                                if(differentHours%10 in 2..4) {
                                    "$differentHours часа назад"
                                } else if(differentHours%10 == 1 && differentHours != 11) {
                                    "$differentHours час назад"
                                }
                                else{
                                    "$differentHours часа назад"
                                }
                            }
                            in 22..26 -> "день назад"
                            else -> when(differentDays) {
                                1 ->  "день назад"
                                in 2..360 -> {
                                    if(differentDays%10 in 2..4 ) {
                                        "$differentDays дня назад"
                                    } else if(differentDays%10 == 1 && differentDays != 11) {
                                        "$differentDays день назад"
                                    }
                                    else{
                                        "$differentDays часа назад"
                                    }
                                }
                                else -> "более года назад"
                            }
                        }
                    }
                }
            }
        }
    }
    else {
        ""
    }

    println(res)
    return res
}

