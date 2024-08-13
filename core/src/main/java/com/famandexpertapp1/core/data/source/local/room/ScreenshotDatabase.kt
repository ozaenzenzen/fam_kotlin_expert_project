package com.famandexpertapp1.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.famandexpertapp1.core.data.source.local.entity.ScreenshotEntity
import com.famandexpertapp1.core.utils.converter.TypeConverterHelper

//@Database(entities = [ScreenshotEntity::class], version = 1, exportSchema = false)
//@TypeConverters(TypeConverterHelper::class)
//abstract class ScreenshotDatabase : RoomDatabase() {
//    abstract fun screenshotDao(): ScreenshotDao
//}