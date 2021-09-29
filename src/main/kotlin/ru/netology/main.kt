package ru.netology

import java.time.LocalTime

fun main() {
    val attachments = AudioAttachment("audio")


    val post1 = Post(id = 135, date = LocalTime.now(), attachment = arrayOf(attachments))
    val post2 = Post(id = 135, date = LocalTime.now(), ownerId = 12345, attachment = arrayOf(attachments))

    WallService.add(post1)
    WallService.update(post2)
}