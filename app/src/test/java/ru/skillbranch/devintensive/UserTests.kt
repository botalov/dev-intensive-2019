package ru.skillbranch.devintensive

import org.junit.Test
import org.junit.Assert.*
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import java.util.*

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

    @Test
    fun builder_test() {
        val user = User.Builder()
            .id("142")
            .firstName("Tom")
            .lastName("Soyer")
            .avatar("https://avatar.jpg")
            .rating(100)
            .respect(51)
            .lastVisit(Date())
            .isOnline(true)
            .build()

        assertEquals("142", user.id)
        assertEquals("Tom", user.firstName)
        assertEquals("Soyer", user.lastName)
        assertEquals("https://avatar.jpg", user.avatar)
        assertEquals(100, user.rating)
        assertEquals(51, user.respect)
        assertEquals(true, user.isOnline)

    }

    @Test
    fun make_message_test() {
        println(BaseMessage.makeMessage(User("1", "Василий", "Иванов"), Chat("123"), Date(), "text", "any text message").formatMessage())
        println(BaseMessage.makeMessage(User("12", "Василий", "Иванов"), Chat("123"), Date(), "image", "https://image.png", true).formatMessage())
    }
}