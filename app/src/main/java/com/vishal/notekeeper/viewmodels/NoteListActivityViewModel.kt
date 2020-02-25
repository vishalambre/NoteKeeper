package com.vishal.notekeeper.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vishal.notekeeper.NoteData
import com.vishal.notekeeper.data.Note

class NoteListActivityViewModel:ViewModel() {
    private val noteList : LiveData<List<Note>> = NoteData.getNotesListLiveData()
    fun getNoteListLiveData() = noteList
}