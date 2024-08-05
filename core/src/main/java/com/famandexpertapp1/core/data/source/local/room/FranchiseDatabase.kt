package com.famandexpertapp1.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.famandexpertapp1.core.data.source.local.entity.FranchiseEntity

@Database(entities = [FranchiseEntity::class], version = 1, exportSchema = false)
abstract class FranchiseDatabase : RoomDatabase() {
    abstract fun franchiseDao(): FranchiseDao
}