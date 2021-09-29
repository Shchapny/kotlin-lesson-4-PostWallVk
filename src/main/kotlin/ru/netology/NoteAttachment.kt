package ru.netology

data class NoteAttachment(
    override val type: String,
    val note: Note? = null
) : Attachment
