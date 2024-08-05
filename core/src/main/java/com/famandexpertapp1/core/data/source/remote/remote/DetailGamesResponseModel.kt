package com.famandexpertapp1.core.data.source.remote.remote

import com.google.gson.annotations.SerializedName

data class DetailGamesResponseModel(

	@field:SerializedName("DetailGamesResponseModel")
	val detailGamesResponseModel: List<DetailGamesResponseModelItem?>? = null
)

data class DetailGamesResponseModelItem(

	@field:SerializedName("keywords")
	val keywords: List<Int?>? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("similar_games")
	val similarGames: List<Int?>? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("videos")
	val videos: List<Int?>? = null,

	@field:SerializedName("aggregated_rating_count")
	val aggregatedRatingCount: Int? = null,

	@field:SerializedName("alternative_names")
	val alternativeNames: List<Int?>? = null,

	@field:SerializedName("player_perspectives")
	val playerPerspectives: List<Int?>? = null,

	@field:SerializedName("screenshots")
	val screenshots: List<Int?>? = null,

	@field:SerializedName("platforms")
	val platforms: List<Int?>? = null,

	@field:SerializedName("cover")
	val cover: Int? = null,

	@field:SerializedName("themes")
	val themes: List<Int?>? = null,

	@field:SerializedName("age_ratings")
	val ageRatings: List<Int?>? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Int? = null,

	@field:SerializedName("collections")
	val collections: List<Int?>? = null,

	@field:SerializedName("first_release_date")
	val firstReleaseDate: Int? = null,

	@field:SerializedName("genres")
	val genres: List<Int?>? = null,

	@field:SerializedName("release_dates")
	val releaseDates: List<Int?>? = null,

	@field:SerializedName("storyline")
	val storyline: String? = null,

	@field:SerializedName("checksum")
	val checksum: String? = null,

	@field:SerializedName("total_rating")
	val totalRating: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("parent_game")
	val parentGame: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("hypes")
	val hypes: Int? = null,

	@field:SerializedName("franchises")
	val franchises: List<Int?>? = null,

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("game_modes")
	val gameModes: List<Int?>? = null,

	@field:SerializedName("external_games")
	val externalGames: List<Int?>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("rating_count")
	val ratingCount: Int? = null,

	@field:SerializedName("tags")
	val tags: List<Int?>? = null,

	@field:SerializedName("language_supports")
	val languageSupports: List<Int?>? = null,

	@field:SerializedName("artworks")
	val artworks: List<Int?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("total_rating_count")
	val totalRatingCount: Int? = null,

	@field:SerializedName("aggregated_rating")
	val aggregatedRating: Double? = null,

	@field:SerializedName("game_engines")
	val gameEngines: List<Int?>? = null,

	@field:SerializedName("websites")
	val websites: List<Int?>? = null,

	@field:SerializedName("category")
	val category: Int? = null,

	@field:SerializedName("involved_companies")
	val involvedCompanies: List<Int?>? = null
)
