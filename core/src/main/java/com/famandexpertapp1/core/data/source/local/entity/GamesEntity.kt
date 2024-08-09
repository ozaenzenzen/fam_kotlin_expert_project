package com.famandexpertapp1.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
//@Entity(tableName = "games_table")
//data class GamesEntity(
//    @PrimaryKey
//    @NonNull
//    @ColumnInfo("id")
//    val id: Int,
//
//    @ColumnInfo("keywords")
//    val keywords: List<Int?>,
//
//    @ColumnInfo("rating")
//    val rating: Double,
//
//    @ColumnInfo("similar_games")
//    val similarGames: List<Int?>,
//
//    @ColumnInfo("created_at")
//    val createdAt: Int,
//
//    @ColumnInfo("videos")
//    val videos: List<Int?>,
//
//    @ColumnInfo("aggregated_rating_count")
//    val aggregatedRatingCount: Int,
//
//    @ColumnInfo("alternative_names")
//    val alternativeNames: List<Int?>,
//
//    @ColumnInfo("player_perspectives")
//    val playerPerspectives: List<Int?>,
//
//    @ColumnInfo("screenshots")
//    val screenshots: List<Int?>,
//
//    @ColumnInfo("platforms")
//    val platforms: List<Int?>,
//
//    @ColumnInfo("cover")
//    val cover: Int,
//
//    @ColumnInfo("themes")
//    val themes: List<Int?>,
//
//    @ColumnInfo("age_ratings")
//    val ageRatings: List<Int?>,
//
//    @ColumnInfo("updated_at")
//    val updatedAt: Int,
//
//    @ColumnInfo("collections")
//    val collections: List<Int?>,
//
//    @ColumnInfo("first_release_date")
//    val firstReleaseDate: Int,
//
//    @ColumnInfo("genres")
//    val genres: List<Int?>,
//
//    @ColumnInfo("release_dates")
//    val releaseDates: List<Int?>,
//
//    @ColumnInfo("storyline")
//    val storyline: String,
//
//    @ColumnInfo("checksum")
//    val checksum: String,
//
//    @ColumnInfo("total_rating")
//    val totalRating: Double,
//
//    @ColumnInfo("parent_game")
//    val parentGame: Int,
//
//    @ColumnInfo("slug")
//    val slug: String,
//
//    @ColumnInfo("hypes")
//    val hypes: Int,
//
//    @ColumnInfo("franchises")
//    val franchises: List<Int?>,
//
//    @ColumnInfo("summary")
//    val summary: String,
//
//    @ColumnInfo("game_modes")
//    val gameModes: List<Int?>,
//
//    @ColumnInfo("external_games")
//    val externalGames: List<Int?>,
//
//    @ColumnInfo("url")
//    val url: String,
//
//    @ColumnInfo("rating_count")
//    val ratingCount: Int,
//
//    @ColumnInfo("tags")
//    val tags: List<Int?>,
//
//    @ColumnInfo("language_supports")
//    val languageSupports: List<Int?>,
//
//    @ColumnInfo("artworks")
//    val artworks: List<Int?>,
//
//    @ColumnInfo("name")
//    val name: String,
//
//    @ColumnInfo("total_rating_count")
//    val totalRatingCount: Int,
//
//    @ColumnInfo("aggregated_rating")
//    val aggregatedRating: Double,
//
//    @ColumnInfo("game_engines")
//    val gameEngines: List<Int?>,
//
//    @ColumnInfo("websites")
//    val websites: List<Int?>,
//
//    @ColumnInfo("category")
//    val category: Int,
//
//    @ColumnInfo("involved_companies")
//    val involvedCompanies: List<Int?>,
//
//    @ColumnInfo(name = "isFavorite")
//    var isFavorite: Boolean = false,
//) : Parcelable