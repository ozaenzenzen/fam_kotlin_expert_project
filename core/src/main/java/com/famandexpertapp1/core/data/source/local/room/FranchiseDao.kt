package com.famandexpertapp1.core.data.source.local.room

import androidx.room.*
import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import io.reactivex.Completable
import kotlinx.coroutines.flow.Flow

@Dao
interface FranchiseDao {
    @Query("SELECT * FROM franchise_table")
    fun getAllFranchise(): Flow<List<FranchiseEntity>>

    @Query("SELECT * FROM franchise_table where isFavorite = 1")
    fun getFavoriteFranchise(): Flow<List<FranchiseEntity>>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertFranchise(tourism: List<FranchiseEntity>)

    @Update
    fun updateFavoriteFranchise(tourism: FranchiseEntity)
}