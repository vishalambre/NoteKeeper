package com.vishal.notekeeper.ui.notelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishal.notekeeper.NoteData
import com.vishal.notekeeper.R
import com.vishal.notekeeper.databinding.ActivityNoteListBinding
import com.vishal.notekeeper.extensionutils.startActivity
import com.vishal.notekeeper.ui.newnote.NewNoteActivity
import com.vishal.notekeeper.viewmodels.NoteListActivityViewModel

class NoteListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteListBinding
    private lateinit var viewModel: NoteListActivityViewModel
    private val noteListAdapter = NoteListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note_list)
        viewModel = ViewModelProvider(this).get(NoteListActivityViewModel::class.java)
        initRecyclerView()
        initListeners()
        initObservers()
    }

    private fun initObservers(){
        viewModel.getNoteListLiveData().observe(this, Observer{
            noteListAdapter.setNotes(it)
        })
    }

    private fun initRecyclerView() {
        binding.rcvNoteList.apply {
            layoutManager = LinearLayoutManager(this@NoteListActivity)
            binding.rcvNoteList.adapter = noteListAdapter
        }
    }

    private fun initListeners(){
        binding.fabNewNote.setOnClickListener{startActivity<NewNoteActivity>()}
    }
}
