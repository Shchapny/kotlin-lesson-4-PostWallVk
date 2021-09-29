package ru.netology

data class VideoAttachment(
    override val type: String,
    val video: Video? = null
) : Attachment
