package com.atahan.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.atahan.noteapp.R
import com.atahan.noteapp.adapter.NoteAdapter
import com.atahan.noteapp.databinding.FragmentNoteListBinding
import com.atahan.noteapp.model.NoteEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentNoteListBinding

    @Inject
    lateinit var noteAdapter: NoteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fab listener
        binding.fabAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_noteListFragment_to_noteAddFragment)
        }

        //recyclerview & adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(this@NoteListFragment.context)
            adapter = noteAdapter
        }


        return binding.root
    }

}