package com.atahan.noteapp.presenter.listfragment

interface ListFragmentContractor {

    interface IListFragment {
        fun navigate()
        fun deleteAll()
    }

    interface IListFragmentPresenter {
        fun onCLickNavigate()
        fun clickDelete()
    }

}