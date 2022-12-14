package com.atahan.noteapp.presenter.addfragment

import javax.inject.Inject

class AddFragmentPresenter @Inject constructor() : AddFragmentContractor.IAddFragmentPresenter {
    private lateinit var view: AddFragmentContractor.IAddFragment

    override fun addNote() {
        view.saveNote()
    }

    override fun navigate() {
        view.navigateBack()
    }
}