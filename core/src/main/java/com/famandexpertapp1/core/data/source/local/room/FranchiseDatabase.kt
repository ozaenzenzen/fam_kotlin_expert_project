package com.famandexpertapp1.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity
import com.famandexpertapp1.core.data.source.local.entity.GamesEntity
import com.famandexpertapp1.core.data.source.local.entity.ScreenshotEntity
import com.famandexpertapp1.core.utils.converter.TypeConverterHelper

@Database(
    entities = [FranchiseEntity::class, ScreenshotEntity::class, GamesEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverterHelper::class)
abstract class FranchiseDatabase : RoomDatabase() {
    abstract fun franchiseDao(): FranchiseDao
    abstract fun screenshotDao(): ScreenshotDao
    abstract fun gamesDao(): GamesDao
}