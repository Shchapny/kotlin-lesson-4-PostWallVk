package ru.netology

import java.time.LocalTime

data class Post(
    val id: Int?,
    val ownerId: Int? = null,
    val fromId: Int? = null,
    val createdBy: Int? = null,
    val date: LocalTime?,
    val text: String? = null,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Int? = null,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes? = null,
    val reposts: Reposts? = null,
    val views: Views? = null,
    val postType: String? = null,
    val signerId: Int? = null,
    val canPin: Boolean? = null,
    val canDelete: Boolean? = null,
    val canEdit: Boolean? = null,
    val isPinned: Int? = null,
    val markedAsAds: Boolean? = null,
    val isFavorite: Boolean? = null,
    val donut: Donut? = null,
    val postponedId: Int? = null,
    val attachment: Array<Attachment>? = null
)
