package com.oznyigit.notesapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.oznyigit.notesapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private var noteRepo: NoteRepository) : ViewModel() {

    fun updateNote(id: Int, title: String, content: String)
    {
        CoroutineScope(Dispatchers.Main).launch {
            noteRepo.update(id, title, content)
        }
    }
}