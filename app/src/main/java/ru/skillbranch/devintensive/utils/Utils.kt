package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?) : Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(if(firstName.isNullOrEmpty()) null else firstName, if(lastName.isNullOrEmpty()) null else lastName)
    }
}