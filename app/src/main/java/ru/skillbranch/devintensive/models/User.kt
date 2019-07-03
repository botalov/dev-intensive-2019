package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.lang.Exception
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
    }

    data class Builder (
            var id: String? = null,
            var firstName: String? = null,
            var lastName: String? = null,
            var avatar: String? = null,
            var rating: Int = 0,
            var respect: Int = 0,
            var lastVisit: Date? = Date(),
            var isOnline: Boolean = false) {

        fun id(id: String) = apply { this.id = id }

        fun firstName(firstName: String) = apply {this.firstName = firstName}

        fun lastName(lastName: String) = apply { this.lastName = lastName }

        fun avatar(avatar: String) = apply { this.avatar = avatar }

        fun rating(rating: Int) = apply { this.rating = rating }

        fun respect(respect: Int) = apply { this.respect = respect }

        fun lastVisit(lastVisit: Date) = apply { this.lastVisit = lastVisit }

        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }


        fun build(): User {
            if (id.isNullOrEmpty()) {
                throw Exception("id is null")
            }
            return User(id!!, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
        }
    }
}