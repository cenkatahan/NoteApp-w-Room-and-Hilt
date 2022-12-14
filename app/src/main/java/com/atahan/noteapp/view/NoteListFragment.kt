package com.atahan.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.atahan.noteapp.R
import com.atahan.noteapp.adapter.NoteAdapter
import com.atahan.noteapp.databinding.FragmentNoteListBinding
import com.atahan.noteapp.presenter.listfragment.ListFragmentContractor
import com.atahan.noteapp.presenter.listfragment.ListFragmentPresenter
import com.atahan.noteapp.repository.NoteRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteListFragment : Fragment(), ListFragmentContractor.IListFragment {
    private lateinit var binding: FragmentNoteListBinding

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var repository: NoteRepository

    @Inject
    lateinit var presenter: ListFragmentPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
            presenter.onCLickNavigate()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListBinding.inflate(inflater, container, false)

        presenter.setView(this)
        noteAdapter.differ.submitList(repository.getNotes())
        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(this@NoteListFragment.context)
            adapter = noteAdapter
        }

        binding.btnDelete.setOnClickListener {
            presenter.clickDelete()
        }

        return binding.root
    }

    override fun navigate() {
        this@NoteListFragment.findNavController()
            .navigate(R.id.action_noteListFragment_to_noteAddFragment)
    }

    override fun deleteAll() {
        repository.deleteNotes()
        noteAdapter.differ.submitList(repository.getNotes())
    }

}