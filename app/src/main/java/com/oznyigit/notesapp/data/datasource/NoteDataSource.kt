package com.oznyigit.notesapp.data.datasource

import com.oznyigit.notesapp.data.entity.Note
import com.oznyigit.notesapp.room.NoteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteDataSource(private var noteDao: NoteDao) {

    suspend fun deleteNote(id: Int) {
        val deletedNote = Note(id, "", "")
        noteDao.delete(deletedNote)
    }

    suspend fun loadNotes(): List<Note> =
        withContext(Dispatchers.IO) {
            return@withContext noteDao.loadNotes()
        }

    suspend fun saveNote(title: String, content: String) {
        val newNote = Note(0, title, content)
        noteDao.save(newNote)
    }

    suspend fun search(word: String): List<Note> =
        withContext(Dispatchers.IO) {
            return@withContext noteDao.search(word)
        }

    suspend fun updateNote(id: Int, title: String, content: String) {
        val updatedNote = Note(id, title, content)
        noteDao.update(updatedNote)
    }

}