package com.famandexpertapp1.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.famandexpertapp1.core.data.source.local.entity.ScreenshotEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScreenshotDao {
    @Query("SELECT * FROM screenshot_table")
    fun getAllScreenshot(): Flow<List<ScreenshotEntity>>

    @Query("SELECT * FROM screenshot_table where id = :gamesID")
    fun getScreenshotSingleData(gamesID: String): Flow<List<ScreenshotEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertScreenshot(screenshot: List<ScreenshotEntity>)
}