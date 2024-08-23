package com.famandexpertapp1.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FranchiseDao {
    @Query("SELECT * FROM franchise_table")
    fun getAllFranchise(): Flow<List<FranchiseEntity>>

    @Query("SELECT * FROM franchise_table where isFavorite = 1")
    fun getFavoriteFranchise(): Flow<List<FranchiseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFranchise(tourism: List<FranchiseEntity>)

    @Update
    fun updateFavoriteFranchise(tourism: FranchiseEntity)
}