package com.oznyigit.notesapp.data.repository

import com.oznyigit.notesapp.data.entity.Note
import com.oznyigit.notesapp.data.datasource.NoteDataSource

class NoteRepository(private var nds: NoteDataSource) {
    suspend fun delete(id: Int) = nds.deleteNote(id)
    suspend fun loadNotes() : List<Note> = nds.loadNotes()
    suspend fun save(title: String, content: String) = nds.saveNote(title,content)
    suspend fun search(word: String) : List<Note> = nds.search(word)
    suspend fun update(id: Int,title: String,content: String) = nds.updateNote(id,title,content)
}