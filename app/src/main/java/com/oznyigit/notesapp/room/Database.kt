package com.oznyigit.notesapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oznyigit.notesapp.data.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
}