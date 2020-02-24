package com.vishal.notekeeper.ui.notelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishal.notekeeper.R
import com.vishal.notekeeper.data.Note
import com.vishal.notekeeper.databinding.ActivityNoteListBinding
import com.vishal.notekeeper.extensionutils.startActivity
import com.vishal.notekeeper.ui.newnote.NewNoteActivity

class NoteListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note_list)
        initRecyclerView()
        initListeners()
    }
    //Todo the implementation when the note creation and saving logic is done
    private fun initRecyclerView() {
        val noteList = initializeDummyNoteList()
        val noteListAdapter =
            NoteListAdapter(noteList)
        binding.rcvNoteList.apply {
            layoutManager = LinearLayoutManager(this@NoteListActivity)
            binding.rcvNoteList.adapter = noteListAdapter
        }
    }

    private fun initializeDummyNoteList(): List<Note> {
        val noteList = mutableListOf<Note>()
        repeat(10) {
            noteList.add(Note("Title $it", "Description $it"))
        }
        return noteList
    }
    private fun initListeners(){
        binding.fabNewNote.setOnClickListener{startActivity<NewNoteActivity>()}
    }
}
