package ru.netology

data class Comment(
    val ownerId: Int? = null, // идентификатор пользователя или сообщества
    val postId: Int? = null, // идентификатор записи на стене.
    val fromGroup: Int = 0, // 	идентификатор сообщества, от имени которого публикуется комментарий
    var message: String? = null, // текст комментария
    val replyToComment: Int? = null, // идентификатор комментария, в ответ на который должен быть добавлен новый комментарий
    val attachment: Attachment? = null, // список объектов, приложенных к комментарию и разделённых символом
    val stickerId: Int = 0, // идентификатор стикера
    val guid: String? = null, // уникальный идентификатор
    val commentId: Int = 1 // идентификатор комментария
)
