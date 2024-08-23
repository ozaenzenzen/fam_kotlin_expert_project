package com.famandexpertapp1.core.utils

import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import com.famandexpertapp1.core.data.source.local.entity.ScreenshotEntity
import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ScreenshotResponseModelItem
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import com.famandexpertapp1.core.domain.model.Screenshot

object DataMapper {
    fun mapGamesResponsesToEntities(input: List<DetailGamesResponseModelItem?>): List<GamesEntity> {
        val gamesList = ArrayList<GamesEntity>()
        input.map {
            val games = GamesEntity(
                keywords = it?.keywords ?: emptyList(),
                rating = it?.rating ?: 0.0,
                similarGames = it?.similarGames ?: emptyList(),
                createdAt = it?.createdAt ?: 0,
                videos = it?.videos ?: emptyList(),
                aggregatedRatingCount = it?.aggregatedRatingCount ?: 0,
                alternativeNames = it?.alternativeNames ?: emptyList(),
                playerPerspectives = it?.playerPerspectives ?: emptyList(),
                screenshots = it?.screenshots ?: emptyList(),
                platforms = it?.platforms ?: emptyList(),
                cover = it?.cover ?: 0,
                themes = it?.themes ?: emptyList(),
                ageRatings = it?.ageRatings ?: emptyList(),
                updatedAt = it?.updatedAt ?: 0,
                collections = it?.collections ?: emptyList(),
                firstReleaseDate = it?.firstReleaseDate ?: 0,
                genres = it?.genres ?: emptyList(),
                releaseDates = it?.releaseDates ?: emptyList(),
                storyline = it?.storyline ?: "",
                checksum = it?.checksum ?: "",
                totalRating = it?.totalRating ?: 0.0,
                id = it?.id!!,
                parentGame = it.parentGame ?: 0,
                slug = it.slug ?: "",
                hypes = it.hypes ?: 0,
                franchises = it.franchises ?: emptyList(),
                summary = it.summary ?: "",
                gameModes = it.gameModes ?: emptyList(),
                externalGames = it.externalGames ?: emptyList(),
                url = it.url ?: "",
                ratingCount = it.ratingCount ?: 0,
                tags = it.tags ?: emptyList(),
                languageSupports = it.languageSupports ?: emptyList(),
                artworks = it.artworks ?: emptyList(),
                name = it.name ?: "",
                totalRatingCount = it.totalRatingCount ?: 0,
                aggregatedRating = it.aggregatedRating ?: 0.0,
                gameEngines = it.gameEngines ?: emptyList(),
                websites = it.websites ?: emptyList(),
                category = it.category ?: 0,
                involvedCompanies = it.involvedCompanies ?: emptyList(),
                isFavorite = false,
            )
            gamesList.add(games)
        }
        return gamesList
    }
//    fun mapGamesResponsesToEntities(input: List<DetailGamesResponseModelItem?>): List<GamesEntity> {
//        val gamesList = ArrayList<GamesEntity>()
//        input.map { it ->
//            val games = GamesEntity(
//                keywords = it?.keywords ?: null,
//                rating = it?.rating ?: null,
//                similarGames = it?.similarGames ?: null,
//                createdAt = it?.createdAt ?: null,
//                videos = it?.videos ?: null,
//                aggregatedRatingCount = it?.aggregatedRatingCount ?: null,
//                alternativeNames = it?.alternativeNames ?: null,
//                playerPerspectives = it?.playerPerspectives ?: null,
//                screenshots = it?.screenshots ?: null,
//                platforms = it?.platforms ?: null,
//                cover = it?.cover ?: null,
//                themes = it?.themes ?: null,
//                ageRatings = it?.ageRatings ?: null,
//                updatedAt = it?.updatedAt ?: null,
//                collections = it?.collections ?: null,
//                firstReleaseDate = it?.firstReleaseDate ?: null,
//                genres = it?.genres ?: null,
//                releaseDates = it?.releaseDates ?: null,
//                storyline = it?.storyline ?: null,
//                checksum = it?.checksum ?: null,
//                totalRating = it?.totalRating ?: null,
//                id = it?.id!!,
//                parentGame = it?.parentGame ?: null,
//                slug = it?.slug ?: null,
//                hypes = it?.hypes ?: null,
//                franchises = it?.franchises ?: null,
//                summary = it?.summary ?: null,
//                gameModes = it?.gameModes ?: null,
//                externalGames = it?.externalGames ?: null,
//                url = it?.url ?: null,
//                ratingCount = it?.ratingCount ?: null,
//                tags = it?.tags ?: null,
//                languageSupports = it?.languageSupports ?: null,
//                artworks = it?.artworks ?: null,
//                name = it?.name ?: null,
//                totalRatingCount = it?.totalRatingCount ?: null,
//                aggregatedRating = it?.aggregatedRating ?: null,
//                gameEngines = it?.gameEngines ?: null,
//                websites = it?.websites ?: null,
//                category = it?.category ?: null,
//                involvedCompanies = it?.involvedCompanies ?: null,
//                isFavorite = false,
//            )
//            gamesList.add(games)
//        }
//        return gamesList
//    }

    fun mapGamesEntitiesToDomain(input: List<GamesEntity>): List<Games> =
        input.map {
            Games(
                keywords = it.keywords,
                rating = it.rating,
                similarGames = it.similarGames,
                createdAt = it.createdAt,
                videos = it.videos,
                aggregatedRatingCount = it.aggregatedRatingCount,
                alternativeNames = it.alternativeNames,
                playerPerspectives = it.playerPerspectives,
                screenshots = it.screenshots,
                platforms = it.platforms,
                cover = it.cover,
                themes = it.themes,
                ageRatings = it.ageRatings,
                updatedAt = it.updatedAt,
                collections = it.collections,
                firstReleaseDate = it.firstReleaseDate,
                genres = it.genres,
                releaseDates = it.releaseDates,
                storyline = it.storyline,
                checksum = it.checksum,
                totalRating = it.totalRating,
                id = it.id,
                parentGame = it.parentGame,
                slug = it.slug,
                hypes = it.hypes,
                franchises = it.franchises,
                summary = it.summary,
                gameModes = it.gameModes,
                externalGames = it.externalGames,
                url = it.url,
                ratingCount = it.ratingCount,
                tags = it.tags,
                languageSupports = it.languageSupports,
                artworks = it.artworks,
                name = it.name,
                totalRatingCount = it.totalRatingCount,
                aggregatedRating = it.aggregatedRating,
                gameEngines = it.gameEngines,
                websites = it.websites,
                category = it.category,
                involvedCompanies = it.involvedCompanies,
                isFavorite = it.isFavorite,
            )
        }

    fun mapFranchiseResponsesToEntities(input: List<ListFranchiseResponseModelItem?>): List<FranchiseEntity> {
        val franchiseList = ArrayList<FranchiseEntity>()
        input.map {
            val franchise = FranchiseEntity(
                id = it?.id!!,
                updatedAt = it.updatedAt!!,
                games = it.games!!,
                name = it.name!!,
                checksum = it.checksum!!,
                createdAt = it.createdAt!!,
                slug = it.slug!!,
                url = it.url!!,
                isFavorite = false,
            )
            franchiseList.add(franchise)
        }
        return franchiseList
    }

    fun mapFranchiseEntitiesToDomain(input: List<FranchiseEntity>): List<Franchise> =
        input.map {
            Franchise(
                id = it.id,
                updatedAt = it.updatedAt,
                games = it.games,
                name = it.name,
                checksum = it.checksum,
                createdAt = it.createdAt,
                slug = it.slug,
                url = it.url,
                isFavorite = it.isFavorite,
                image = it.image,
            )
        }

    fun mapFranchiseDomainToEntity(input: Franchise) = FranchiseEntity(
        id = input.id,
        updatedAt = input.updatedAt,
        games = input.games,
        name = input.name,
        checksum = input.checksum,
        createdAt = input.createdAt,
        slug = input.slug,
        url = input.url,
        image = input.image,
        isFavorite = input.isFavorite,
    )

    fun mapScreenshotResponsesToEntities(input: List<ScreenshotResponseModelItem?>): List<ScreenshotEntity> {
        val screenshotList = ArrayList<ScreenshotEntity>()
        input.map {
            val screenshot = ScreenshotEntity(
                game = it!!.game ?: 0,
                width = it.width ?: 0,
                checksum = it.checksum ?: "",
                id = it.id ?: 0,
                imageId = it.imageId ?: "",
                url = it.url ?: "",
                height = it.height ?: 0,
                alphaChannel = it.alphaChannel ?: false,
                animated = it.animated ?: false,
            )
            screenshotList.add(screenshot)
        }
        return screenshotList
    }

    fun mapScreenshotEntitiesToDomain(input: List<ScreenshotEntity>): List<Screenshot> =
        input.map {
            Screenshot(
                game = it.game,
                width = it.width,
                checksum = it.checksum,
                id = it.id,
                imageId = it.imageId,
                url = it.url,
                height = it.height,
                alphaChannel = it.alphaChannel,
                animated = it.animated,
            )
        }

}