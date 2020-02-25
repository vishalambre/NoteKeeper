package com.vishal.notekeeper.ui.notelist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vishal.notekeeper.R
import com.vishal.notekeeper.data.Note
import com.vishal.notekeeper.extensionutils.getFormatterDateTime
import com.vishal.notekeeper.ui.notedetail.NOTE_KEY
import com.vishal.notekeeper.ui.notedetail.NoteDetailsActivity

class NoteListAdapter(private val context: Context) :
    RecyclerView.Adapter<NoteListAdapter.NoteItemViewHolder>() {
    private var noteList = listOf<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note_list, parent, false)
        return NoteItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val note = noteList[position]
        holder.setNoteDetails(note)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, NoteDetailsActivity::class.java)
            intent.putExtra(NOTE_KEY, note)
            context.startActivity(intent)
        }
    }

    fun setNotes(noteList: List<Note>) {
        this.noteList = noteList
        //New item will always be inserted on the 0th location
        notifyItemInserted(0)
    }

    inner class NoteItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNoteTitle: TextView = itemView.findViewById(R.id.tv_note_title)
        private val tvNoteDescription: TextView = itemView.findViewById(R.id.tv_note_description)
        private val tvNoteTimeStamp: TextView = itemView.findViewById(R.id.tv_note_timestamp)

        /*
        * setNoteDetails is exposed because it is mandatory to have both title and description
        */
        fun setNoteDetails(note: Note) {
            setNoteTitle(note.title)
            setNoteDescription(note.description)
            setNoteTimeStamp(note.timeStamp)
        }

        /*
        * setNoteTitle is private as only note title cannot be set as per requirement;
        * if it changes this can be made public
        */
        private fun setNoteTitle(titleText: String) {
            tvNoteTitle.text = titleText
        }

        /*
        * setNoteDescription is private as only note title cannot be set as per requirement;
        * if it changes this can be made public
        */
        private fun setNoteDescription(descriptionText: String) {
            tvNoteDescription.text = descriptionText
        }

        private fun setNoteTimeStamp(timeStamp:Long){
            tvNoteTimeStamp.text = timeStamp.getFormatterDateTime()
        }
    }
}