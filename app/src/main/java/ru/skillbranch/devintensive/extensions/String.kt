package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16) : String {
    val sourceString = this.trim()

    if(length > sourceString.length) {
        return sourceString
    }

    return sourceString.substring(0, length).trim() + "..."
}

fun String.stripHtml() : String {
    val str = this.replace(Regex("\\<[^>]*>") ,"")
    return str.replace(Regex(" {2}") ,"").trim()
}