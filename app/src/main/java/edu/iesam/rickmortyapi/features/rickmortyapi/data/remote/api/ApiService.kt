package edu.iesam.rickmortyapi.features.rickmortyapi.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): ApiResponse

}