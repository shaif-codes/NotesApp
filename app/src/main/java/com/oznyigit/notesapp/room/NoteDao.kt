package com.oznyigit.notesapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.oznyigit.notesapp.data.entity.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun loadNotes(): List<Note>

    @Insert
    suspend fun save(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE content like '%' ||:word||'%'")
    suspend fun search(word: String) : List<Note>

}