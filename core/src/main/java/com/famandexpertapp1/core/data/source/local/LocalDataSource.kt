package com.famandexpertapp1.core.data.source.local

import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import com.famandexpertapp1.core.data.source.local.room.FranchiseDao
import com.famandexpertapp1.core.data.source.local.room.GamesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val franchiseDao: FranchiseDao,
    private val gamesDao: GamesDao,
) {

//    companion object {
//        private var instance: LocalDataSource? = null
//
//        fun getInstance(tourismDao: TourismDao): LocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: LocalDataSource(tourismDao)
//            }
//    }

    fun getAllFranchise(): Flow<List<FranchiseEntity>> = franchiseDao.getAllFranchise()

    fun getFavoriteTourism(): Flow<List<FranchiseEntity>> = franchiseDao.getFavoriteFranchise()

    suspend fun insertTourism(tourismList: List<FranchiseEntity>) =
        franchiseDao.insertFranchise(tourismList)

    fun setFavoriteTourism(frachise: FranchiseEntity, newState: Boolean) {
        frachise.isFavorite = newState
        franchiseDao.updateFavoriteFranchise(frachise)
    }

    fun getAllGames(): Flow<List<GamesEntity>> = gamesDao.getAllGames()
}