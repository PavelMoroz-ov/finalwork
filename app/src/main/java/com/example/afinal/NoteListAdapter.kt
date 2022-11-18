package com.example.afinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.databinding.NoteItemBinding
import com.example.afinal.room.Notes


class NoteListAdapter: RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    fun updateList(notes: List<Notes>){
        this.notes = notes
        notifyDataSetChanged()
    }

    var notes: List<Notes> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var binding: NoteItemBinding = NoteItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.notes = notes[position]
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}