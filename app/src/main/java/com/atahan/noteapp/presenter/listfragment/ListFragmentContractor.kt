package com.atahan.noteapp.presenter.listfragment

interface ListFragmentContractor {

    interface IListFragment {
        fun navigate()
    }

    interface IListFragmentPresenter {
        fun onCLickNavigate()
    }

}