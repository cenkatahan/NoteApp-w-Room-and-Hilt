package com.atahan.noteapp.presenter.listfragment

import javax.inject.Inject

class ListFragmentPresenter @Inject constructor() : ListFragmentContractor.IListFragmentPresenter {

    private lateinit var view: ListFragmentContractor.IListFragment

    override fun onCLickNavigate() {
        view.navigate()
    }

    override fun clickDelete() {
        view.deleteAll()
    }

    fun setView(iView: ListFragmentContractor.IListFragment) {
        view = iView
    }
}