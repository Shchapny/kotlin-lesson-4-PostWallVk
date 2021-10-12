package ru.netology

import java.time.LocalTime

fun main() {
    val attachments = AudioAttachment("audio")


    val post1 = Post(id = 135, date = LocalTime.now(), attachment = arrayOf(attachments))
    val post2 = Post(id = 135, date = LocalTime.now(), ownerId = 12345, attachment = arrayOf(attachments))

    WallService.add(post1)
    WallService.update(post2)

    val comment1 = Comment(postId = 1, message = "Комментарий к посту")
    val comment2 = Comment(postId = 2, message = "Новый комментарий к посту")

    WallService.createComment(comment1)
    WallService.createComment(comment2)

    val note1 = Note(title = "Title1", text = "text1", noteId = 1, ownerId = 14)
    val note2 = Note(title = "Title2", text = "text2", noteId = 2, ownerId = 14)
    val note3 = Note(title = "Title3", text = "text3", noteId = 1, ownerId = 14)

    val commentNote = Comment(commentId = 2, ownerId = 10, replyToComment = 16, message = "comment1")
    val commentNoteEdit = Comment(commentId = 2, ownerId = 10, replyToComment = 16, message = "comment2")


    NoteService.add(note1)
    NoteService.createComment(commentNote)
    NoteService.delete(2)
    NoteService.edit(note2)
    NoteService.editComment(commentNoteEdit)
    NoteService.get(note3)
    NoteService.getById(note1)
    NoteService.deleteComment(2)
    NoteService.restoreComment(commentNote)
    NoteService.getComments(note3)


}