package com.famandexpertapp1.core.data.source.local.room

import androidx.room.*
import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
//import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import io.reactivex.Completable
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Query("SELECT * FROM games_table")
    fun getAllGames(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM games_table where id = :gamesID")
    fun getGames(gamesID: String): Flow<List<GamesEntity>>

    @Query("SELECT * FROM games_table where isFavorite = 1")
    fun getFavoriteGames(): Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GamesEntity>)

    @Update
    fun updateFavoriteGames(games: GamesEntity)
}