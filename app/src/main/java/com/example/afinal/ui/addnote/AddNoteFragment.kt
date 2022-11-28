package com.example.afinal.ui.addnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.room.Delete
import androidx.room.Room
import com.example.afinal.databinding.FragmentAddnoteBinding

import com.example.afinal.room.DbConnection
import com.example.afinal.room.Notes
import com.example.afinal.room.NoteRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddnoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddnoteBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bSave.setOnClickListener {
            var name = binding.edName.text.toString()
            var data = binding.edData.text.toString()
            var dataEnd = binding.edDataEnd.text.toString()


            val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "dbNote").build()
            val repository = NoteRepository(db)

            GlobalScope.launch {
                repository.insert(Notes(name, data, dataEnd))
            }

        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}