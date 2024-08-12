package com.famandexpertapp1.core.utils

import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import com.famandexpertapp1.core.data.source.local.entity.ScreenshotEntity
//import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ScreenshotResponseModelItem
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import com.famandexpertapp1.core.domain.model.Screenshot

object DataMapper {
//    fun mapGamesEntitiesToDomain(input: List<GamesEntity>): List<Games> =
//        input.map {
//            Games(
//                keywords = it.keywords,
//                rating = it.rating,
//                similarGames = it.similarGames,
//                createdAt = it.createdAt,
//                videos = it.videos,
//                aggregatedRatingCount = it.aggregatedRatingCount,
//                alternativeNames = it.alternativeNames,
//                playerPerspectives = it.playerPerspectives,
//                screenshots = it.screenshots,
//                platforms = it.platforms,
//                cover = it.cover,
//                themes = it.themes,
//                ageRatings = it.ageRatings,
//                updatedAt = it.updatedAt,
//                collections = it.collections,
//                firstReleaseDate = it.firstReleaseDate,
//                genres = it.genres,
//                releaseDates = it.releaseDates,
//                storyline = it.storyline,
//                checksum = it.checksum,
//                totalRating = it.totalRating,
//                id = it.id,
//                parentGame = it.parentGame,
//                slug = it.slug,
//                hypes = it.hypes,
//                franchises = it.franchises,
//                summary = it.summary,
//                gameModes = it.gameModes,
//                externalGames = it.externalGames,
//                url = it.url,
//                ratingCount = it.ratingCount,
//                tags = it.tags,
//                languageSupports = it.languageSupports,
//                artworks = it.artworks,
//                name = it.name,
//                totalRatingCount = it.totalRatingCount,
//                aggregatedRating = it.aggregatedRating,
//                gameEngines = it.gameEngines,
//                websites = it.websites,
//                category = it.category,
//                involvedCompanies = it.involvedCompanies,
//                isFavorite = it.isFavorite,
//            )
//        }
//
//    fun mapGamesDomainToEntity(input: Games) = GamesEntity(
//        keywords = input.keywords,
//        rating = input.rating,
//        similarGames = input.similarGames,
//        createdAt = input.createdAt,
//        videos = input.videos,
//        aggregatedRatingCount = input.aggregatedRatingCount,
//        alternativeNames = input.alternativeNames,
//        playerPerspectives = input.playerPerspectives,
//        screenshots = input.screenshots,
//        platforms = input.platforms,
//        cover = input.cover,
//        themes = input.themes,
//        ageRatings = input.ageRatings,
//        updatedAt = input.updatedAt,
//        collections = input.collections,
//        firstReleaseDate = input.firstReleaseDate,
//        genres = input.genres,
//        releaseDates = input.releaseDates,
//        storyline = input.storyline,
//        checksum = input.checksum,
//        totalRating = input.totalRating,
//        id = input.id,
//        parentGame = input.parentGame,
//        slug = input.slug,
//        hypes = input.hypes,
//        franchises = input.franchises,
//        summary = input.summary,
//        gameModes = input.gameModes,
//        externalGames = input.externalGames,
//        url = input.url,
//        ratingCount = input.ratingCount,
//        tags = input.tags,
//        languageSupports = input.languageSupports,
//        artworks = input.artworks,
//        name = input.name,
//        totalRatingCount = input.totalRatingCount,
//        aggregatedRating = input.aggregatedRating,
//        gameEngines = input.gameEngines,
//        websites = input.websites,
//        category = input.category,
//        involvedCompanies = input.involvedCompanies,
//        isFavorite = input.isFavorite,
//    )

    fun mapFranchiseResponsesToEntities(input: List<ListFranchiseResponseModelItem?>): List<FranchiseEntity> {
        val franchiseList = ArrayList<FranchiseEntity>()
        input.map { it ->
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
        input.map { it ->
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

    fun mapScreenshotDomainToEntity(input: Screenshot) = ScreenshotEntity(
        game = input.game!!,
        width = input.width!!,
        checksum = input.checksum!!,
        id = input.id!!,
        imageId = input.imageId!!,
        url = input.url!!,
        height = input.height!!,
        alphaChannel = input.alphaChannel!!,
        animated = input.animated!!,
    )
}