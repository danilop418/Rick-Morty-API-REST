package edu.iesam.rickmortyapi.features.rickmortyapi.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import edu.iesam.rickmortyapi.features.rickmortyapi.data.remote.api.ApiService
import edu.iesam.rickmortyapi.features.rickmortyapi.presentation.CharacterModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class Repository @Inject constructor(val api: ApiService) {

    companion object {
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 3
    }

    fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100),
            pagingSourceFactory = {
                CharacterPagingSource(api)
            }).flow
    }
}