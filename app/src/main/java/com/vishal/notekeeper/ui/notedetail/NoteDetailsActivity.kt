package com.vishal.notekeeper.ui.notedetail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vishal.notekeeper.R
import com.vishal.notekeeper.data.Note
import com.vishal.notekeeper.databinding.ActivityNoteDetailsBinding
import com.vishal.notekeeper.extensionutils.getFormatterDateTime
import java.text.SimpleDateFormat
import java.util.*


const val NOTE_KEY = "com.vishal.notekeeper.ui.notedetail.NOTE"
class NoteDetailsActivity:AppCompatActivity() {
    private lateinit var binding:ActivityNoteDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if(intent!=null){
            val note = intent.getParcelableExtra<Note>(NOTE_KEY)
            binding.tvNoteTitle.text = note?.title
            binding.tvNoteDescription.text = note?.description
            binding.tvNoteTimestamp.text = note?.timeStamp?.getFormatterDateTime()
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