package com.example.afinal.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface NoteDao {

    @Query("Select * from Notes")
    fun getAll(): LiveData<List<Notes>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(notes: Notes)

}