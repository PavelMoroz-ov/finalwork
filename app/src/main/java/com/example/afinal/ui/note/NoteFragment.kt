package com.example.afinal.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.afinal.NoteListAdapter
import com.example.afinal.databinding.FragmentNoteBinding

import com.example.afinal.room.DbConnection
import com.example.afinal.room.NoteRepository

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "dbNote").build()
        val repository = NoteRepository(db)
        val adapter = NoteListAdapter()

        repository.notes.observe(viewLifecycleOwner){
            adapter.updateList(it)
        }

        binding.userListRecyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}