package ru.skillbranch.devintensive.models

import java.lang.Exception
import java.util.*

class UserBuilder {


    private var id: String? = null
    private var firstName : String? = null
    private var lastName : String? = null
    private var avatar : String? = null
    private var rating : Int = 0
    private var respect : Int = 0
    private var lastVisit : Date? = Date()
    private var isOnline : Boolean = false

    fun id(value: String) : UserBuilder {
        id = value
        return this
    }

    fun firstName(value: String) : UserBuilder {
        firstName = value
        return this
    }

    fun lastName(value: String) : UserBuilder {
        lastName = value
        return this
    }

    fun avatar(value: String) : UserBuilder {
        avatar = value
        return this
    }

    fun rating(value: Int) : UserBuilder {
        rating = value
        return this
    }

    fun respect(value: Int) : UserBuilder {
        respect = value
        return this
    }

    fun lastVisit(value: Date) : UserBuilder {
        lastVisit = value
        return this
    }

    fun isOnline(value: Boolean) : UserBuilder {
        isOnline = value
        return this
    }




    fun build() : User{
        if(id.isNullOrEmpty()) {
            throw Exception("id is null")
        }
        return User(id!!, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
    }
}