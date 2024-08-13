package com.famandexpertapp1.core.di

import android.content.Context
import androidx.room.Room
import com.famandexpertapp1.core.data.source.local.room.FranchiseDao
import com.famandexpertapp1.core.data.source.local.room.FranchiseDatabase
import com.famandexpertapp1.core.data.source.local.room.GamesDao
import com.famandexpertapp1.core.data.source.local.room.ScreenshotDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseFranchise(@ApplicationContext context: Context): FranchiseDatabase =
        Room.databaseBuilder(
            context,
            FranchiseDatabase::class.java, "Franchise.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideFranchiseDao(database: FranchiseDatabase): FranchiseDao =
        database.franchiseDao()

    @Provides
    fun provideGamesDao(database: FranchiseDatabase): GamesDao =
        database.gamesDao()

    @Provides
    fun provideScreenshotDao(database: FranchiseDatabase): ScreenshotDao =
        database.screenshotDao()
}