package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        val note = Note(noteId = 1)
        NoteService.add(note)
        val result = NoteService.add(note).noteId

        assertEquals(6, result)
    }

    @Test
    fun createComment() {
        val note = Note(replyTo = 1)
        NoteService.add(note)
        val comment = Comment(replyToComment = 1)
        NoteService.createComment(comment)
        val result = comment.replyToComment

        assertEquals(1, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowCreateComment() {
        val comment = Comment(replyToComment = 2)
        NoteService.createComment(comment)
    }

    @Test
    fun delete() {
        val note = Note(noteId = 1)
        NoteService.add(note)
        val result = NoteService.delete(1)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowDeleteNote () {
        val note = Note(noteId =  1)
        NoteService.delete(5)
    }

    @Test
    fun deleteComment() {
        val note = Note(noteId = 0)
        NoteService.add(note)
        val comment = Comment(commentId = 2)
        NoteService.createComment(comment)
        val result = NoteService.deleteComment(1)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowDeleteComment () {
        val comment = Comment(commentId = 1)
        NoteService.deleteComment(2)
    }

    @Test
    fun edit() {
        val note = Note(noteId = 1)
        NoteService.add(note)
        val edit = Note(noteId = 5)
        val result = NoteService.edit(edit)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowEditNote() {
        val note = Note(noteId = 1)
        NoteService.edit(note)
    }

    @Test
    fun editComment() {
        val note = Note(noteId = 1)
        NoteService.add(note)
        val comment = Comment(commentId = 1, ownerId = 1)
        NoteService.createComment(comment)
        val edit = Comment(commentId = 1, ownerId = 1)
        val result = NoteService.editComment(edit)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowEditComment() {
        val comment = Comment(commentId = 2, ownerId = 14)
        NoteService.editComment(comment)
    }

    @Test
    fun get() {
        val note = Note(noteId = 7, noteIds = 1)
        NoteService.add(note)
        NoteService.get(note)
        val result = note

        assertEquals(note, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowGetNotes() {
        val note = Note(noteIds = 2, userId = 1)
        val getNote = Note(noteIds = 87, userId = 1)
        NoteService.get(getNote)
    }

    @Test
    fun getById() {
        val note = Note(noteId = 1, userId = 6)
        NoteService.add(note)
        NoteService.getById(3)
        val result = note

        assertEquals(note, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowGetById() {
        val note = Note(noteId = 1, ownerId = 2)
        NoteService.getById(44)
    }

    @Test
    fun getComments() {
        val note = Note(noteId = 1, ownerId = 10)
        NoteService.add(note)
        val comment = Comment(commentId = 2, ownerId = 10)
        NoteService.createComment(comment)
        val result = comment.commentId

        assertEquals(2, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowGetComments() {
        val comment = Note(ownerId = 10)
        val getComment = Note(ownerId = 11)
        NoteService.getComments(getComment)
    }

    @Test
    fun restoreComment() {
        val note = Note(noteId = 1)
        NoteService.add(note)
        val comment = Comment(commentId = 2, ownerId = 4)
        NoteService.createComment(comment)
        NoteService.deleteComment(2)
        val result = NoteService.restoreComment(2)

        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowRestore() {
        val comment = Comment(commentId = 2, ownerId = 5)
        NoteService.restoreComment(3)
    }
}