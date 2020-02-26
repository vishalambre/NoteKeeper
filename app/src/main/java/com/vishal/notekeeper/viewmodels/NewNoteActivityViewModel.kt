package com.vishal.notekeeper.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vishal.notekeeper.NoteData
import com.vishal.notekeeper.data.Note

class NewNoteActivityViewModel : ViewModel() {
    private val isNoteValid: MutableLiveData<Boolean> = MutableLiveData()

    /*
     * This Strings fields can also be converted into livedata's; and the activity connected to it should consume the fields from those livedata;
     * Using this edit note functionality can be added if required
     */
    private var noteTitle = ""
    private var noteDescription = ""

    init {
        isNoteValid.value = false
    }

    fun getIsNoteValidLiveData(): LiveData<Boolean> = isNoteValid
    fun setNoteTitleChanged(noteTitle: String) {
        this.noteTitle = noteTitle
        handleFabVisibility()
    }

    fun setNoteDescriptionChanged(noteDescription: String) {
        this.noteDescription = noteDescription
        handleFabVisibility()
    }

    fun saveNote() {
        NoteData.addNote(getNote())
    }

    fun getNote(): Note = Note(noteTitle, noteDescription)

    private fun handleFabVisibility() {
        isNoteValid.postValue(noteTitle.trim().isNotEmpty() && noteDescription.trim().isNotEmpty())
    }

}