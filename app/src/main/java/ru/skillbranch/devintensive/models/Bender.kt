package ru.skillbranch.devintensive.models

class Bender {

    enum class Status{
        NORMAL,
        WARNING,
        DANGER,
        CRITICAL,
    }

    enum class Question {
        NAME,
        PROFESSION,
        MATERIAL,
        BDAY,
        SERIAL,
        IDLE,
    }
}