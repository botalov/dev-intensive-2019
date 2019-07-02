package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

private const val SECOND = 1000L
private const val MINUTE = 60 * SECOND
private const val HOUR = 60 * MINUTE
private const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy") : String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}


fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("invalid units")
    }
    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
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
                        else if((differentMinutes%10 == 1 || differentMinutes%100 == 1) && differentMinutes != 11 && differentMinutes != 111) {
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
                                    if(differentHours in 11..19) {
                                        "$differentHours часов назад"
                                    }
                                    else {
                                        "$differentHours часа назад"
                                    }
                                } else if((differentHours%10 == 1 || differentHours%100 == 1) && differentHours != 11) {
                                    "$differentHours час назад"
                                }
                                else{
                                    "$differentHours часов назад"
                                }
                            }
                            in 22..26 -> "день назад"
                            else -> when(differentDays) {
                                1 ->  "день назад"
                                in 2..360 -> {
                                    if(differentDays%10 in 2..4 ) {
                                        if(differentDays in 11..19) {
                                            "$differentDays дней назад"
                                        }
                                        else {
                                            "$differentDays дня назад"
                                        }
                                    } else if((differentDays%10 == 1 || differentDays%100 == 1) && differentDays != 11) {
                                        "$differentDays день назад"
                                    }
                                    else{
                                        "$differentDays дней назад"
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
        when(abs(different)) {
            in 0..1 -> "только что"
            in 1..45 -> "через несколько секунд"
            in 45..75 -> "через минуту"
            else ->{
                when(differentMinutes) {
                    1 -> "через минуту"
                    in 2..45 -> {
                        if(differentMinutes%10 in 2..4) {
                            if(differentMinutes in 11..19) {
                                "через $differentMinutes минут"
                            }
                            else {
                                "через $differentMinutes минуты"
                            }
                        }
                        else if((differentMinutes%10 == 1 || differentMinutes%100 == 1) && differentMinutes != 11 && differentMinutes != 111) {
                            "через $differentMinutes минуту"
                        }
                        else{
                            "через $differentMinutes минут"
                        }
                    }
                    in 45..75 -> "через час"
                    else-> {
                        when(differentHours) {
                            1 ->  "через час"
                            in 2..22 -> {
                                if(differentHours%10 in 2..4) {
                                    if(differentHours in 11..19) {
                                        "через $differentHours часов"
                                    }
                                    else {
                                        "через $differentHours часа"
                                    }
                                } else if((differentHours%10 == 1 || differentHours%100 == 1) && differentHours != 11) {
                                    "через $differentHours час"
                                }
                                else{
                                    "через $differentHours часов"
                                }
                            }
                            in 22..26 -> "через день"
                            else -> when(differentDays) {
                                1 ->  "через день"
                                in 2..360 -> {
                                    if(differentDays%10 in 2..4 ) {
                                        if(differentDays in 11..19) {
                                            "через $differentDays дней"
                                        }
                                        else {
                                            "через $differentDays дня"
                                        }
                                    } else if((differentDays%10 == 1 || differentDays%100 == 1) && differentDays != 11) {
                                        "через $differentDays день"
                                    }
                                    else{
                                        "через $differentDays дней"
                                    }
                                }
                                else -> "более чем через год"
                            }
                        }
                    }
                }
            }
        }
    }

    println(res)
    return res
}

