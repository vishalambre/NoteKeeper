package com.vishal.notekeeper.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewNoteActivityViewModel : ViewModel() {
    private val showFab: MutableLiveData<Boolean> = MutableLiveData()
    private var noteTitle = ""
    private var noteDescription = ""

    init {
        showFab.value = false
    }

    fun getShowFabLiveData(): LiveData<Boolean> = showFab
    fun setNoteTitleChanged(noteTitle: String) {
        this.noteTitle = noteTitle
        handleFabVisibility()
    }

    fun setNoteDescriptionChanged(noteDescription: String) {
        this.noteDescription = noteDescription
        handleFabVisibility()
    }

    fun saveNote() {
    //Todo implement the saving note functionality
    }

    private fun handleFabVisibility() {
        showFab.postValue(noteTitle.isNotEmpty() && noteDescription.isNotEmpty())
    }

}