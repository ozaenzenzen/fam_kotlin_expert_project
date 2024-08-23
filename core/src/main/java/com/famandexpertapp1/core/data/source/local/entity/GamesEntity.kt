package com.famandexpertapp1.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "games_table")
data class GamesEntity(
    @PrimaryKey
    @ColumnInfo("id")
    var id: Int,

    @ColumnInfo("keywords")
    var keywords: List<Int?>,

    @ColumnInfo("rating")
    var rating: Double,

    @ColumnInfo("similar_games")
    var similarGames: List<Int?>,

    @ColumnInfo("created_at")
    var createdAt: Int,

    @ColumnInfo("videos")
    var videos: List<Int?>,

    @ColumnInfo("aggregated_rating_count")
    var aggregatedRatingCount: Int,

    @ColumnInfo("alternative_names")
    var alternativeNames: List<Int?>,

    @ColumnInfo("player_perspectives")
    var playerPerspectives: List<Int?>,

    @ColumnInfo("screenshots")
    var screenshots: List<Int?>,

    @ColumnInfo("platforms")
    var platforms: List<Int?>,

    @ColumnInfo("cover")
    var cover: Int,

    @ColumnInfo("themes")
    var themes: List<Int?>,

    @ColumnInfo("age_ratings")
    var ageRatings: List<Int?>,

    @ColumnInfo("updated_at")
    var updatedAt: Int,

    @ColumnInfo("collections")
    var collections: List<Int?>,

    @ColumnInfo("first_release_date")
    var firstReleaseDate: Int,

    @ColumnInfo("genres")
    var genres: List<Int?>,

    @ColumnInfo("release_dates")
    var releaseDates: List<Int?>,

    @ColumnInfo("storyline")
    var storyline: String,

    @ColumnInfo("checksum")
    var checksum: String,

    @ColumnInfo("total_rating")
    var totalRating: Double,

    @ColumnInfo("parent_game")
    var parentGame: Int,

    @ColumnInfo("slug")
    var slug: String,

    @ColumnInfo("hypes")
    var hypes: Int,

    @ColumnInfo("franchises")
    var franchises: List<Int?>,

    @ColumnInfo("summary")
    var summary: String,

    @ColumnInfo("game_modes")
    var gameModes: List<Int?>,

    @ColumnInfo("external_games")
    var externalGames: List<Int?>,

    @ColumnInfo("url")
    var url: String,

    @ColumnInfo("rating_count")
    var ratingCount: Int,

    @ColumnInfo("tags")
    var tags: List<Int?>,

    @ColumnInfo("language_supports")
    var languageSupports: List<Int?>,

    @ColumnInfo("artworks")
    var artworks: List<Int?>,

    @ColumnInfo("name")
    var name: String,

    @ColumnInfo("total_rating_count")
    var totalRatingCount: Int,

    @ColumnInfo("aggregated_rating")
    var aggregatedRating: Double,

    @ColumnInfo("game_engines")
    var gameEngines: List<Int?>,

    @ColumnInfo("websites")
    var websites: List<Int?>,

    @ColumnInfo("category")
    var category: Int,

    @ColumnInfo("involved_companies")
    var involvedCompanies: List<Int?>,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,
) : Parcelable

//@Parcelize
//@Entity(tableName = "games_table")
//data class GamesEntity(
//    @PrimaryKey
//    @NonNull
//    @ColumnInfo("id")
//    var id: Int,
//
//    @ColumnInfo("keywords")
//    var keywords: List<Int?>?,
//    @ColumnInfo("rating")
//    var rating: Double?,
//    @ColumnInfo("similar_games")
//    var similarGames: List<Int?>?,
//    @ColumnInfo("created_at")
//    var createdAt: Int?,
//    @ColumnInfo("videos")
//    var videos: List<Int?>?,
//    @ColumnInfo("aggregated_rating_count")
//    var aggregatedRatingCount: Int?,
//    @ColumnInfo("alternative_names")
//    var alternativeNames: List<Int?>?,
//    @ColumnInfo("player_perspectives")
//    var playerPerspectives: List<Int?>?,
//    @ColumnInfo("screenshots")
//    var screenshots: List<Int?>?,
//    @ColumnInfo("platforms")
//    var platforms: List<Int?>?,
//    @ColumnInfo("cover")
//    var cover: Int?,
//    @ColumnInfo("themes")
//    var themes: List<Int?>?,
//    @ColumnInfo("age_ratings")
//    var ageRatings: List<Int?>?,
//    @ColumnInfo("updated_at")
//    var updatedAt: Int?,
//    @ColumnInfo("collections")
//    var collections: List<Int?>?,
//    @ColumnInfo("first_release_date")
//    var firstReleaseDate: Int?,
//    @ColumnInfo("genres")
//    var genres: List<Int?>?,
//    @ColumnInfo("release_dates")
//    var releaseDates: List<Int?>?,
//    @ColumnInfo("storyline")
//    var storyline: String?,
//    @ColumnInfo("checksum")
//    var checksum: String?,
//    @ColumnInfo("total_rating")
//    var totalRating: Double?,
//    @ColumnInfo("parent_game")
//    var parentGame: Int?,
//    @ColumnInfo("slug")
//    var slug: String?,
//    @ColumnInfo("hypes")
//    var hypes: Int?,
//    @ColumnInfo("franchises")
//    var franchises: List<Int?>?,
//    @ColumnInfo("summary")
//    var summary: String?,
//    @ColumnInfo("game_modes")
//    var gameModes: List<Int?>?,
//    @ColumnInfo("external_games")
//    var externalGames: List<Int?>?,
//    @ColumnInfo("url")
//    var url: String?,
//    @ColumnInfo("rating_count")
//    var ratingCount: Int?,
//    @ColumnInfo("tags")
//    var tags: List<Int?>?,
//    @ColumnInfo("language_supports")
//    var languageSupports: List<Int?>?,
//    @ColumnInfo("artworks")
//    var artworks: List<Int?>?,
//    @ColumnInfo("name")
//    var name: String?,
//    @ColumnInfo("total_rating_count")
//    var totalRatingCount: Int?,
//    @ColumnInfo("aggregated_rating")
//    var aggregatedRating: Double?,
//    @ColumnInfo("game_engines")
//    var gameEngines: List<Int?>?,
//    @ColumnInfo("websites")
//    var websites: List<Int?>?,
//    @ColumnInfo("category")
//    var category: Int?,
//    @ColumnInfo("involved_companies")
//    var involvedCompanies: List<Int?>?,
//
//    @ColumnInfo(name = "isFavorite")
//    var isFavorite: Boolean = false,
//) : Parcelable