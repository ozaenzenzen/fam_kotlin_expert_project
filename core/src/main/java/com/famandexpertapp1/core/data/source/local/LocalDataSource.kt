package com.famandexpertapp1.core.data.source.local

import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import com.famandexpertapp1.core.data.source.local.entity.ScreenshotEntity
import com.famandexpertapp1.core.data.source.local.room.FranchiseDao
import com.famandexpertapp1.core.data.source.local.room.GamesDao
import com.famandexpertapp1.core.data.source.local.room.ScreenshotDao
import com.famandexpertapp1.core.data.source.local.userpref.UserDataPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val userDataPreferences: UserDataPreferences,
    private val franchiseDao: FranchiseDao,
    private val screenshotDao: ScreenshotDao,
    private val gamesDao: GamesDao,
) {

    fun getAllFranchise(): Flow<List<FranchiseEntity>> = franchiseDao.getAllFranchise()

    fun getFavoriteFranchise(): Flow<List<FranchiseEntity>> = franchiseDao.getFavoriteFranchise()

    suspend fun insertFranchise(tourismList: List<FranchiseEntity>) =
        franchiseDao.insertFranchise(tourismList)

    fun setFavoriteFranchise(franchise: FranchiseEntity, newState: Boolean) {
        franchise.isFavorite = newState
        franchiseDao.updateFavoriteFranchise(franchise)
    }

    fun getAllGames(): Flow<List<GamesEntity>> = gamesDao.getAllGames()

    fun getGames(gamesID: String): Flow<List<GamesEntity>> = gamesDao.getGames(gamesID)

    fun getFavoriteGames(): Flow<List<GamesEntity>> = gamesDao.getFavoriteGames()

    suspend fun insertGames(gamesList: List<GamesEntity>) =
        gamesDao.insertGames(gamesList)

    fun setFavoriteGames(games: GamesEntity, newState: Boolean) {
        games.isFavorite = newState
        gamesDao.updateFavoriteGames(games)
    }

    fun getToken(): Flow<String?> {
        return userDataPreferences.getToken()
    }

    suspend fun setToken(value: String) {
        userDataPreferences.setToken(value)
    }

    fun getAllScreenshot(): Flow<List<ScreenshotEntity>> = screenshotDao.getAllScreenshot()

    fun getScreenshotSingleData(gamesID: String): Flow<List<ScreenshotEntity>> = screenshotDao.getScreenshotSingleData(gamesID)

    suspend fun insertScreenshot(screenshotList: List<ScreenshotEntity>) =
        screenshotDao.insertScreenshot(screenshotList)
}