package com.vishal.notekeeper.ui.newnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vishal.notekeeper.R
import com.vishal.notekeeper.databinding.ActivityNewNoteBinding

class NewNoteActivity: AppCompatActivity() {
    private lateinit var binding:ActivityNewNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_note)
    }
}