package ru.skillbranch.devintensive.models

import java.util.*

class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false)
{

    constructor(id:String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    companion object Factory{
        private var lastId = -1
        fun makeUser(fullName: String?) : User{
            lastId++

            val parts = fullName?.trim()?.split(" ")

            val firstName = parts?.getOrElse(0) {""}
            val lastName = parts?.getOrElse(1) {""}

            return User("$lastId",
                if(firstName.isNullOrEmpty()) "" else firstName,
                if(lastName.isNullOrEmpty()) "" else lastName)
        }
    }
}