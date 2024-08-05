package com.famandexpertapp1.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Query("SELECT * FROM games_table")
    fun getAllGames(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM games_table where isFavorite = 1")
    fun getFavoriteGames(): Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(tourism: List<GamesEntity>)

    @Update
    fun updateFavoriteGames(tourism: GamesEntity)
}