package ru.netology

data class Note(
    var title: String? = null, // заголовок заметки
    var text: String? = null, // текст заметки
    val noteId: Int? = null, // идентификатор заметки
    val ownerId: Int? = null, // идентификатор владельца заметки
    val replyTo: Int? = null, // идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий
    val message: String? = null, // текст комментария
//    val commentId: Int, // перенёс в data-class Comment
    val noteIds: Int? = null, // идентификаторы заметок, информацию о которых необходимо получить
    val userId: Int? = null, // идентификатор пользователя, информацию о заметках которого требуется получить
    val count: Int = 20, // количество заметок, информацию о которых необходимо получить.
    var isDeleted: Boolean = false // удалён или не удалён пост
) {
    fun delete() {
        isDeleted = true
    }
}