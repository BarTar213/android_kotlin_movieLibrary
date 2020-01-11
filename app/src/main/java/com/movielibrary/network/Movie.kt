package com.movielibrary.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "vote_average") val rating: Double = 0.0,
    @Json(name = "release_date") val releaseDate: String = ""
) : Parcelable

@Parcelize
data class MovieDetails(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String = "",
    @Json(name = "vote_average") val rating: Double = 0.0,
    @Json(name = "release_date") val releaseDate: String = "",
    val budget: Int = 0,
    val revenue: Int = 0,
    @Json(name = "runtime") val runTime: Int = 0,
    val genres: List<Genre> = emptyList()
) : Parcelable

@Parcelize
data class Genre(
    val id: Int,
    val name: String
) : Parcelable