package com.vishal.notekeeper.ui.newnote

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vishal.notekeeper.R
import com.vishal.notekeeper.databinding.ActivityNewNoteBinding
import com.vishal.notekeeper.viewmodels.NewNoteActivityViewModel

class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding
    private lateinit var viewModel: NewNoteActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_note)
        viewModel = ViewModelProvider(this).get(NewNoteActivityViewModel::class.java)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.etNoteTitle.addTextChangedListener(object : GenericTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setNoteTitleChanged(s.toString())
            }
        })
        binding.etNoteDescription.addTextChangedListener(object : GenericTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setNoteDescriptionChanged(s.toString())
            }
        })
        binding.fabSaveNote.setOnClickListener {
            viewModel.saveNote()
        }
    }

    private fun initObservers() {
        viewModel.getShowFabLiveData().observe(this, Observer { handleFabVisibility(it) })
    }

    private fun handleFabVisibility(fabVisibility: Boolean) {
        when {
            fabVisibility -> binding.fabSaveNote.show()
            else -> binding.fabSaveNote.hide()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}