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


        fun Builder(): UserBuilder {
            return UserBuilder()
        }


        class UserBuilder {
            private var id: String? = null
            private var firstName: String? = null
            private var lastName: String? = null
            private var avatar: String? = null
            private var rating: Int = 0
            private var respect: Int = 0
            private var lastVisit: Date? = Date()
            private var isOnline: Boolean = false

            fun id(value: String): UserBuilder {
                id = value
                return this
            }

            fun firstName(value: String): UserBuilder {
                firstName = value
                return this
            }

            fun lastName(value: String): UserBuilder {
                lastName = value
                return this
            }

            fun avatar(value: String): UserBuilder {
                avatar = value
                return this
            }

            fun rating(value: Int): UserBuilder {
                rating = value
                return this
            }

            fun respect(value: Int): UserBuilder {
                respect = value
                return this
            }

            fun lastVisit(value: Date): UserBuilder {
                lastVisit = value
                return this
            }

            fun isOnline(value: Boolean): UserBuilder {
                isOnline = value
                return this
            }


            fun build(): User {
                if (id.isNullOrEmpty()) {
                    throw Exception("id is null")
                }
                return User(id!!, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
            }
        }
    }
}