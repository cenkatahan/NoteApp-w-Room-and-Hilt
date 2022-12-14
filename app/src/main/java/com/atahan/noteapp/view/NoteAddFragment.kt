package com.atahan.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.atahan.noteapp.R
import com.atahan.noteapp.databinding.FragmentNoteAddBinding
import com.atahan.noteapp.model.NoteEntity
import com.atahan.noteapp.repository.NoteRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteAddFragment : Fragment() {
    private lateinit var binding: FragmentNoteAddBinding

    @Inject
    lateinit var repository: NoteRepository

    @Inject
    lateinit var note: NoteEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNoteAddBinding.inflate(inflater, container, false)

        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val desc = binding.etDesc.text.toString()

            repository.add(
                NoteEntity(
                    id = 0,
                    title = title,
                    desc = desc
                )
            )

            it.findNavController().navigate(R.id.action_noteAddFragment_to_noteListFragment)
        }

        return binding.root
    }

}