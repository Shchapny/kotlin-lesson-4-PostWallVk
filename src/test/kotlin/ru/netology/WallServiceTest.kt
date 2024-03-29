package ru.netology

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalTime

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(id = 14, date = LocalTime.now())

        val result = WallService.add(post).id

        assertEquals(3, result)
    }

    @Test
    fun update_true() {
        val post = Post(id = 14, date = LocalTime.now())
        val post2 = Post(id = 1, date = LocalTime.now(), ownerId = 12345)
        WallService.add(post)
        val result = WallService.update(post2)
        assertTrue(result)
    }
    @Test
    fun update_false() {
        val post = Post(id = 14, date = LocalTime.now())
        val post2 = Post(id = 9, date = LocalTime.now(), ownerId = 12345)
        WallService.add(post)
        val result = WallService.update(post2)
        assertFalse(result)
    }
}