package com.example.myapplication

import androidx.lifecycle.LiveData
import retrofit2.http.GET

interface ApiService {

    @GET("albums")
    suspend fun getAllAlbumList():List<Album>
}