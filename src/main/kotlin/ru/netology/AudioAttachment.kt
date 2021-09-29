package ru.netology

data class AudioAttachment(
    override val type: String,
    val audio: Audio? = null
) : Attachment {

}
