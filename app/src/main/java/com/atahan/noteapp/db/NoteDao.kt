package com.atahan.noteapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.atahan.noteapp.model.NoteEntity
import com.atahan.noteapp.utils.Constants.NOTE_TABLE
import java.util.ArrayList

@Dao
interface NoteDao {

    @Query("SELECT * FROM $NOTE_TABLE")
    fun getNotes(): ArrayList<NoteEntity>

    @Insert
    fun add(note: NoteEntity)

    @Query("DELETE FROM $NOTE_TABLE")
    fun deleteNotes();
}