package com.atahan.noteapp.repository

import com.atahan.noteapp.db.NoteDao
import com.atahan.noteapp.model.NoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dao: NoteDao
) {

    fun getNotes() = dao.getNotes()
    fun add(note: NoteEntity) = dao.add(note)
    fun deleteNotes() = dao.deleteNotes()
}