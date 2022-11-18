package com.example.afinal.ui.albums


import com.example.afinal.ui.albums.models.Photo
import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {

    @GET("photos/")
    fun getAll(): Call<List<Photo>>
}