package ru.netology

data class LinkAttachment(
    override val type: String,
    val link: Link? = null
) : Attachment
