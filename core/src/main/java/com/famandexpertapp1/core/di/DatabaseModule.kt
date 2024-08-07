package com.famandexpertapp1.core.di

import android.content.Context
import androidx.room.Room
import com.famandexpertapp1.core.data.source.local.room.FranchiseDao
import com.famandexpertapp1.core.data.source.local.room.FranchiseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseFranchise(context: Context): FranchiseDatabase =
        Room.databaseBuilder(
            context,
            FranchiseDatabase::class.java, "Franchise.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideFranchiseDao(database: FranchiseDatabase): FranchiseDao = database.franchiseDao()
}