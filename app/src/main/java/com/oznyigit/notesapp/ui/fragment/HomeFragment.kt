package com.oznyigit.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.oznyigit.notesapp.R
import com.oznyigit.notesapp.databinding.FragmentHomeBinding
import com.oznyigit.notesapp.ui.adapter.NoteAdapter
import com.oznyigit.notesapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.homeFragment = this
        binding.homeToolbarHeader = "My Notes"

        viewModel.noteList.observe(viewLifecycleOwner) {
            val noteAdapter = NoteAdapter(requireContext(),it,viewModel)
            binding.noteAdapter = noteAdapter
        }

        binding.searchViewHome.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun addButtonClick(it: View)
    {
        Navigation.findNavController(it).navigate(R.id.actionHomeToSave)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadNotes()
    }

}