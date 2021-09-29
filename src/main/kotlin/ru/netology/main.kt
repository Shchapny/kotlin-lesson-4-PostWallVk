package ru.netology

import java.time.LocalTime

fun main() {
    val attachment = AudioAttachment("audio")
    WallService.addArrayAttachment(attachment)


    val post1 = Post(id = 135, date = LocalTime.now())
    val post2 = Post(id = 135, date = LocalTime.now(), ownerId = 12345)

    WallService.add(post1)
    WallService.update(post2)
}