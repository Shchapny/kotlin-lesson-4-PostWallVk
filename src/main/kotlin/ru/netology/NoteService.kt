package ru.netology

import java.awt.datatransfer.ClipboardOwner

object NoteService {

    private val notes: MutableList<Note> = mutableListOf()
    private val comments: MutableList<Comment> = mutableListOf()
//    private val deleteNotes: MutableList<Note> = mutableListOf()
//    private val deleteComment: MutableList<Comment> = mutableListOf()

    fun add(note: Note): Note {
        if (notes.isEmpty()) notes.add(note.copy(noteId = 1))
        else notes.add(note.copy(noteId = notes.last().noteId?.plus(1)))
        return notes.last()
    }

    fun createComment(comment: Comment): Comment {
        for (note in notes) {
            if (note.replyTo == comment.replyToComment) {
                comments += comment
                return comments.last()
            }
        }
        throw NoteNotFoundException("Нет доступа к комментарию, не найден")
    }

    fun delete(deleteIdNote: Int): Boolean {
        for (note in notes) {
            if (deleteIdNote == note.noteId) {
                getById(deleteIdNote).delete()
                notes.remove(note)
                return true
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    fun deleteComment(deleteIdComment: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (deleteIdComment == comment.commentId) {
                if (!comments[index].isDeleted) {
                    comments[index].delete()
                    return true
                }
            }
        }
        throw NoteNotFoundException("Нет доступа к комментарию, не найден")
    }

    fun edit(noteEdit: Note): Boolean {
        for (note in notes) {
            if (noteEdit.noteId == note.noteId) {
                note.title = noteEdit.title
                note.text = noteEdit.text
                return true
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    fun editComment(editComment: Comment): Boolean {
        for (comment in comments) {
            if (editComment.commentId == comment.commentId && editComment.ownerId == comment.ownerId) {
                comment.message = editComment.message
                return true
            }
        }
        throw NoteNotFoundException("Нет доступа к комментарию, не найден")
    }

    fun get(getNote: Note): List<Note> {
        if (getNote.count > 100) throw NoteNotFoundException("Превышено количество заметок")
        for (note in notes) {
            if (note.noteIds == getNote.noteIds && note.userId == getNote.userId) {
                println(note.toString())
                return listOf(note)
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    fun getById(id: Int): Note {
        for (note in notes) {
            if (note.noteId == id && !note.isDeleted) {
                return note
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    fun getComments(getComment: Note): Array<MutableList<Comment>> {
        if (getComment.count > 100) throw NoteNotFoundException("Превышено количество комментариев")
        for (note in notes) {
            if (note.noteId == getComment.noteId && note.ownerId == getComment.ownerId) {
                println(comments.toString())
                return arrayOf(comments)
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    fun restoreComment(id: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (id == comment.commentId) {
                if (comments[index].isDeleted) {
                    comments[index].restore()
                    return true
                }
            }
        }
        throw NoteNotFoundException("Нет доступа к комментарию, не найден")
    }
}