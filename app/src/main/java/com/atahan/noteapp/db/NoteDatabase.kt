package com.atahan.noteapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atahan.noteapp.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}