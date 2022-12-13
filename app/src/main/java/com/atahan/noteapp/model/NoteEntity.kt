package com.atahan.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atahan.noteapp.utils.Constants
import com.atahan.noteapp.utils.Constants.COL_DESC
import com.atahan.noteapp.utils.Constants.COL_TITLE
import com.atahan.noteapp.utils.Constants.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = COL_TITLE)
    val title: String = "",
    @ColumnInfo(name = COL_DESC)
    val desc: String = ""
)