package com.oznyigit.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.oznyigit.notesapp.R
import com.oznyigit.notesapp.databinding.FragmentSaveBinding
import com.oznyigit.notesapp.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel: SaveViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_save,container,false)
        binding.saveFragment = this
        binding.saveFragmentToolbarHeader = "Save Notes"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SaveViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSaveNote(title: String, content: String)
    {
        viewModel.saveNote(title, content)
        findNavController().popBackStack()
    }
}