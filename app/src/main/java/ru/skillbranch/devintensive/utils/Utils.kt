package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {
    fun parseFullName(fullName: String?) : Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(if(firstName.isNullOrEmpty()) null else firstName, if(lastName.isNullOrEmpty()) null else lastName)
    }


    fun toInitials(firstName: String?, lastName: String?) : String? {
        var firstNameVar = firstName
        var lastNameVar = lastName
        if(firstNameVar?.trim().isNullOrEmpty()) {
            firstNameVar = " "
        }
        if(lastNameVar?.trim().isNullOrEmpty()) {
            lastNameVar = " "
        }

        val firstChar = firstNameVar?.get(0)?.toUpperCase()
        val lastChar = lastNameVar?.get(0)?.toUpperCase()

        val builder = StringBuilder()
        if(firstChar != null) {
            builder.append(firstChar)
        }
        if(lastChar != null) {
            builder.append(lastChar)
        }

        val result = builder.toString().trim()
        if(result.isEmpty()) {
            return null
        }

        return result
    }
}