package com.oznyigit.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.oznyigit.notesapp.R
import com.oznyigit.notesapp.databinding.FragmentDetailsBinding
import com.oznyigit.notesapp.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        binding.detailsFragment = this
        binding.detailsFragmentToolbarHeader = "Update Note"

        val bundle: DetailsFragmentArgs by navArgs()
        binding.note = bundle.note

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailsViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdateNote(id: Int, title: String, content: String)
    {
        viewModel.updateNote(id, title, content)
        findNavController().popBackStack()
    }

}