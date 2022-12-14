package com.atahan.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.atahan.noteapp.R
import com.atahan.noteapp.databinding.FragmentNoteAddBinding
import com.atahan.noteapp.model.NoteEntity
import com.atahan.noteapp.presenter.addfragment.AddFragmentContractor
import com.atahan.noteapp.presenter.addfragment.AddFragmentPresenter
import com.atahan.noteapp.repository.NoteRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteAddFragment : Fragment(), AddFragmentContractor.IAddFragment {
    private lateinit var binding: FragmentNoteAddBinding

    @Inject
    lateinit var repository: NoteRepository

    @Inject
    lateinit var note: NoteEntity

    @Inject
    lateinit var presenter: AddFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteAddBinding.inflate(inflater, container, false)

        presenter.setView(this)
        binding.btnAdd.setOnClickListener {
            presenter.addNote()
            presenter.navigate()
            binding.etTitle.text.clear()
            binding.etDesc.text.clear()
        }

        return binding.root
    }

    override fun saveNote() {
        val title = binding.etTitle.text.toString()
        val desc = binding.etDesc.text.toString()

        repository.add(
            NoteEntity(
                id = 0,
                title = title,
                desc = desc
            )
        )
    }

    override fun navigateBack() {
        this.findNavController().navigate(R.id.action_noteAddFragment_to_noteListFragment)
    }

}