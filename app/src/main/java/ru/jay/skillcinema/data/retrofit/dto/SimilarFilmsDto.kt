package ru.jay.skillcinema.data.retrofit.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.jay.skillcinema.data.entity.retrofit.SimilarFilm
import ru.jay.skillcinema.data.entity.retrofit.SimilarFilms

@JsonClass(generateAdapter = true)
data class SimilarFilmsDto(
    @Json(name = "total")
    override val total: Int,
    @Json(name = "items")
    override val items: List<ru.jay.skillcinema.data.retrofit.dto.SimilarFilm>
) : SimilarFilms

@JsonClass(generateAdapter = true)
data class SimilarFilm(
    @Json(name = "filmId")
    override val filmId: Int
) : SimilarFilm {

}

