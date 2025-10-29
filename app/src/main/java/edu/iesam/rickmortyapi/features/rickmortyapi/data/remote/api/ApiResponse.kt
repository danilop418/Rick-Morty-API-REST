package edu.iesam.rickmortyapi.features.rickmortyapi.data.remote.api

import com.google.gson.annotations.SerializedName

class ApiResponse {

    data class Character(
        @SerializedName("info") val information: InfoResponse,
        @SerializedName("results") val results: List<CharacterResponse>,
        )

    data class InfoResponse(
        @SerializedName("count") val count: Int,
        @SerializedName("pages") val pages: Int,
        @SerializedName("next") val next: String?,
        @SerializedName("prev") val prev: String?
    )

    data class CharacterResponse(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: Int,
        @SerializedName("status") val status: String?,
        @SerializedName("image") val image: String?
    )
}