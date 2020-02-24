package com.vishal.notekeeper.ui.notelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vishal.notekeeper.R
import com.vishal.notekeeper.data.Note

class NoteListAdapter(private val noteList: List<Note>) :
    RecyclerView.Adapter<NoteListAdapter.NoteItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note_list, parent, false)
        return NoteItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val note = noteList[position]
        holder.setNoteDetails(note.title,note.description)
    }

    inner class NoteItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNoteTitle: TextView = itemView.findViewById(R.id.tv_note_title)
        private val tvNoteDescription: TextView = itemView.findViewById(R.id.tv_note_description)

        /*
        * setNoteDetails is exposed because it is mandatory to have both title and description
        */
        fun setNoteDetails(title:String,description:String){
            setNoteTitle(title)
            setNoteDescription(description)
        }
        /*
        * setNoteTitle is private as only note title cannot be set as per requirement;
        * if it changes this can be made public
        */
        private fun setNoteTitle(titleText:String){
            tvNoteTitle.text = titleText
        }
        /*
        * setNoteDescription is private as only note title cannot be set as per requirement;
        * if it changes this can be made public
        */
        private fun setNoteDescription(descriptionText: String){
            tvNoteDescription.text = descriptionText
        }
    }
}