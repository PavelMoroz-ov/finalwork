package com.example.afinal.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = true)
abstract class DbConnection : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}