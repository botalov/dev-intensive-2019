package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    companion object {
        private var lastId = -1
        fun makeUser(fullName: String?): User {
            lastId++


            val fullNamePair = Utils.parseFullName(fullName)
            val firstName = fullNamePair.first
            val lastName = fullNamePair.second

            return User(
                "$lastId",
                if (firstName.isNullOrEmpty()) "" else firstName,
                if (lastName.isNullOrEmpty()) "" else lastName
            )
        }


        fun Builder() : UserBuilder {
            return UserBuilder()
        }
    }
}