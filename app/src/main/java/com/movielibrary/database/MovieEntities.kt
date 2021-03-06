package com.movielibrary.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String = "",

    val overview: String = "",

    val popularity: Double = 0.0,

    @ColumnInfo(name = "poster_path")
    val posterPath: String = "",

    val rating: Double = 0.0,

    val releaseDate: String = ""
) : Parcelable

@Entity(
    tableName = "popular_movies_table",
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["id"],
        childColumns = ["id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PopularMovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

@Entity(
    tableName = "recently_viewed_table",
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["id"],
        childColumns = ["movie_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RecentlyViewedMovie(
    val recentRank: Int = 0,
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    val movieId: Int = 0
)

fun List<MovieEntity>.toPopularMovie(): List<PopularMovieEntity> {
    return map {
        PopularMovieEntity(
            id = it.id
        )
    }
}

@Entity(
    tableName = "rated_movies_table",
    primaryKeys = ["movieId", "userId"]
)
data class RatedMovie(
    val movieId: Int = 0,
    val userId: String = "",
    val rating: Float = 0f
)

@Entity(
    tableName = "liked_movies_table",
    primaryKeys = ["movieId", "userId"]
)
data class LikedMovie(
    val movieId: Int = 0,
    val userId: String = ""
)