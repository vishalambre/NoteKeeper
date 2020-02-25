package com.vishal.notekeeper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vishal.notekeeper.data.Note

/*
* A Singleton that holds the Note list data
* Currently the list data is stored in the this object; the class can be swapped out in case of using a DB
*/
object NoteData {
    private var noteListMutableLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    init {
        noteListMutableLiveData.value = listOf()
    }

    fun addNote(note: Note) {
        val newList = mutableListOf<Note>()
        val oldList = noteListMutableLiveData.value
        newList.add(note)
        newList.addAll(oldList!!.asIterable())
        noteListMutableLiveData.postValue(newList.toList())
    }

    fun getNotesListLiveData(): LiveData<List<Note>> = noteListMutableLiveData
}