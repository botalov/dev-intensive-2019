package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {
    const val DICTIONSRY = """"а": "a",

"б": "b",

"в": "v",

"г": "g",

"д": "d",

"е": "e",

"ё": "e",

"ж": "zh",

"з": "z",

"и": "i",

"й": "i",

"к": "k",

"л": "l",

"м": "m",

"н": "n",

"о": "o",

"п": "p",

"р": "r",

"с": "s",

"т": "t",

"у": "u",

"ф": "f",

"х": "h",

"ц": "c",

"ч": "ch",

"ш": "sh",

"щ": "sh'",

"ъ": "",

"ы": "i",

"ь": "",

"э": "e",

"ю": "yu",

"я": "ya","""

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(if (firstName.isNullOrEmpty()) null else firstName, if (lastName.isNullOrEmpty()) null else lastName)
    }


    fun toInitials(firstName: String?, lastName: String?): String? {
        var firstNameVar = firstName
        var lastNameVar = lastName
        if (firstNameVar?.trim().isNullOrEmpty()) {
            firstNameVar = " "
        }
        if (lastNameVar?.trim().isNullOrEmpty()) {
            lastNameVar = " "
        }

        val firstChar = firstNameVar?.get(0)?.toUpperCase()
        val lastChar = lastNameVar?.get(0)?.toUpperCase()

        val builder = StringBuilder()
        if (firstChar != null) {
            builder.append(firstChar)
        }
        if (lastChar != null) {
            builder.append(lastChar)
        }

        val result = builder.toString().trim()
        if (result.isEmpty()) {
            return null
        }

        return result
    }


    fun transliteration(payload: String, divider: String = " "): String {

        val sourceDict = DICTIONSRY.replace("\n", "").split(",")
        val dict: MutableList<Pair<String, String>> = mutableListOf()
        for (pair in sourceDict) {
            val xPair = pair.replace("\"", "").split(":")
            if (xPair.isNotEmpty() && xPair.size == 2) {
                dict.add(Pair(xPair[0], xPair[1]))
            }
        }

        val builder = StringBuilder()
        for (a in payload) {
            val findPair = dict.find { it.first == a.toString().toLowerCase() }
            val symbol: String = when (findPair) {
                null -> {
                    if (a.toString().trim().isEmpty()) {
                        divider
                    } else {
                        a.toString().trim()
                    }
                }
                else -> {
                    if (a.isUpperCase()) {
                        val upperString = findPair.second.trim().substring(0, 1).toUpperCase() + findPair.second.trim().substring(1)
                        upperString.trim()
                    } else {
                        findPair.second.trim()
                    }
                }
            }

            builder.append(symbol)
        }

        return builder.toString()
    }
}