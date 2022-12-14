package com.atahan.noteapp.presenter.addfragment

interface AddFragmentContractor {

    interface IAddFragment{
        fun saveNote()
        fun navigateBack()
    }

    interface IAddFragmentPresenter{
        fun addNote()
        fun navigate()
    }
}