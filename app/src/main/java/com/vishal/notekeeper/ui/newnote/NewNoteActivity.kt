package com.vishal.notekeeper.ui.newnote

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vishal.notekeeper.R
import com.vishal.notekeeper.databinding.ActivityNewNoteBinding
import com.vishal.notekeeper.ui.notedetail.NOTE_KEY
import com.vishal.notekeeper.ui.notedetail.NoteDetailsActivity
import com.vishal.notekeeper.viewmodels.NewNoteActivityViewModel

class NewNoteActivity : AppCompatActivity(), DialogInterface.OnClickListener {
    private lateinit var binding: ActivityNewNoteBinding
    private lateinit var viewModel: NewNoteActivityViewModel
    private var isNoteValid = false
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
            val intent = Intent(this, NoteDetailsActivity::class.java)
            intent.putExtra(NOTE_KEY, viewModel.getNote())
            startActivity(intent)
            finish()
        }
    }

    private fun initObservers() {
        viewModel.getIsNoteValidLiveData().observe(this, Observer { handleValidNoteState(it) })
    }

    private fun handleValidNoteState(isNoteValid: Boolean) {
        this.isNoteValid = isNoteValid
        handleFabVisibility(isNoteValid)
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
                handleBackPress()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        handleBackPress()
    }

    private fun handleBackPress() {
        if (isNoteValid) {
            showAlertDialog()
            return
        }
        super.onBackPressed()
    }

    private fun showAlertDialog() =
        AlertDialog.Builder(this).apply {
            setTitle(R.string.discard_note_waring)
            setMessage(R.string.discard_note_message)
            setPositiveButton(R.string.discard_btn_text, this@NewNoteActivity)
            setNegativeButton(R.string.cancel_btn_text, this@NewNoteActivity)
            show()
        }

    override fun onClick(dialog: DialogInterface?, buttonType: Int) {
        when (buttonType) {
            DialogInterface.BUTTON_POSITIVE -> super.onBackPressed()
            DialogInterface.BUTTON_NEGATIVE -> dialog?.dismiss()
        }
    }
}