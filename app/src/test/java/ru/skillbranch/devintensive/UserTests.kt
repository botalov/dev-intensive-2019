package ru.skillbranch.devintensive

import org.junit.Test
import org.junit.Assert.*
import ru.skillbranch.devintensive.models.User

class UserTests {

    @Test
    fun test_factory(){
        val user1 = User.makeUser("Tom Soyer")
        assertEquals("Tom", user1.firstName)
        assertEquals("Soyer", user1.lastName)

        val user2 = User.makeUser(null)
        assertEquals("", user2.firstName)
        assertEquals("", user2.lastName)

        val user3 = User.makeUser(" ")
        assertEquals("", user3.firstName)
        assertEquals("", user3.lastName)

        val user4 = User.makeUser(" Tom")
        assertEquals("Tom", user4.firstName)
        assertEquals("", user4.lastName)
    }

}