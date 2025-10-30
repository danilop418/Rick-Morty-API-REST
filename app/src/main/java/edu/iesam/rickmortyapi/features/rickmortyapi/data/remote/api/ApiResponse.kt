package edu.iesam.rickmortyapi.features.rickmortyapi.data.remote.api

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("info") val information: InfoResponse,
    @SerializedName("results") val results: List<CharacterResponse>,
)
