package com.atahan.noteapp.presenter.listfragment

class ListFragmentPresenter : ListFragmentContractor.IListFragmentPresenter {

    private lateinit var view: ListFragmentContractor.IListFragment

    override fun onCLickNavigate() {
        view.navigate()
    }

    fun setView(iView: ListFragmentContractor.IListFragment){
        view = iView
    }
}