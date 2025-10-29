package edu.iesam.rickmortyapi.features.rickmortyapi.data

import edu.iesam.rickmortyapi.features.rickmortyapi.data.remote.api.ApiService
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class Repository @Inject constructor(api: ApiService) {

    fun getAllCharacters(): Flow<PagingData<Character>> {}