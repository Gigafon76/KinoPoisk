package ru.jay.skillcinema.presentation.adapters.popularfilms

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.jay.skillcinema.data.retrofit.FilmRepository
import ru.jay.skillcinema.data.entity.retrofit.TopFilmsList

class PopularFilmsPagingSource(private val repository: FilmRepository) :
    PagingSource<Int, TopFilmsList>() {

    override fun getRefreshKey(state: PagingState<Int, TopFilmsList>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopFilmsList> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            repository.getPopularFilms(page)
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}