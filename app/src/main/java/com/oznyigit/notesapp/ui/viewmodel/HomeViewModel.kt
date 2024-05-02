package com.oznyigit.notesapp.ui.viewmodel

import com.oznyigit.notesapp.data.entity.Note
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oznyigit.notesapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var noteRepo: NoteRepository) : ViewModel() {
    var noteList = MutableLiveData<List<Note>>()

    init {
        loadNotes()
    }

    fun loadNotes()
    {
        CoroutineScope(Dispatchers.Main).launch {
            noteList.value = noteRepo.loadNotes()
        }
    }

    fun delete(id: Int)
    {
        CoroutineScope(Dispatchers.Main).launch {
            noteRepo.delete(id)
            loadNotes()
        }
    }

    fun search(word: String)
    {
        CoroutineScope(Dispatchers.Main).launch {
            noteList.value = noteRepo.search(word)
        }
    }
}