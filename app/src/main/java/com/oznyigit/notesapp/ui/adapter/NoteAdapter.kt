package com.oznyigit.notesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.oznyigit.notesapp.R
import com.oznyigit.notesapp.data.entity.Note
import com.oznyigit.notesapp.databinding.CardviewDesignBinding
import com.oznyigit.notesapp.ui.fragment.HomeFragmentDirections
import com.oznyigit.notesapp.ui.viewmodel.HomeViewModel

class NoteAdapter(
    var context: Context,
    private var noteList: List<Note>,
    private var viewModel: HomeViewModel
) : RecyclerView.Adapter<NoteAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardviewDesignBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding : CardviewDesignBinding = DataBindingUtil
            .inflate(LayoutInflater.from(context),R.layout.cardview_design,parent,false)

        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val note = noteList[position]
        val design = holder.design

        design.note = note

        design.cardViewRow.setOnClickListener {
            val info = HomeFragmentDirections.actionHomeToDetails(note)
            Navigation.findNavController(it).navigate(info)
        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,R.string.delete_note_text,Snackbar.LENGTH_LONG)
                .setAction(R.string.yes_text) {
                    viewModel.delete(note.id)
                }.show()
        }
    }

    override fun getItemCount() = noteList.size
}