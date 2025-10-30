package edu.iesam.rickmortyapi.features.rickmortyapi.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.iesam.rickmortyapi.features.rickmortyapi.data.remote.api.ApiService
import edu.iesam.rickmortyapi.features.rickmortyapi.presentation.CharacterModel
import jakarta.inject.Inject
import java.io.IOException

class CharacterPagingSource @Inject constructor(
    private val api: ApiService,
) : PagingSource<Int, CharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {

        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(page)
            val characters = response.results

            val prevKey = if(page>0) page - 1 else null
            val netKey = if(response.information.next != null) page + 1 else null

            LoadResult.Page(data = characters.map{ it.toPresentation() }, prevKey, netKey)

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }
}