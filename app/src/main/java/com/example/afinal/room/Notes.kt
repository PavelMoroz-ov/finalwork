package com.example.afinal.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(var name: String, var data: String, var dataEnd: String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
