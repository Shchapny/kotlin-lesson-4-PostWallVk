package ru.netology

data class PhotoAttachment(
    override val type: String,
    val photo: Photo? = null
) : Attachment {

}
