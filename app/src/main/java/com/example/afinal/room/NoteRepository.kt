package com.example.afinal.room

import androidx.lifecycle.LiveData


class NoteRepository(var dataBase: DbConnection) {

    var notes: LiveData<List<Notes>> = dataBase.noteDao().getAll()

    fun getAll(): LiveData<List<Notes>>{
        return notes
    }

    suspend fun insert(notes: Notes){
        dataBase.noteDao().insert(notes)
    }



}