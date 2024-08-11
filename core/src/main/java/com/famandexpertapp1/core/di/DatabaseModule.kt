package com.famandexpertapp1.core.di

import android.content.Context
import androidx.room.Room
import com.famandexpertapp1.core.data.source.local.room.FranchiseDao
import com.famandexpertapp1.core.data.source.local.room.FranchiseDatabase
//import com.famandexpertapp1.core.data.source.local.room.GamesDao
//import com.famandexpertapp1.core.data.source.local.room.GamesDatabase
import com.famandexpertapp1.core.domain.model.Games
import dagger.Module
import dagger.Provides
import javax.inject.Named
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
    fun provideFranchiseDao(database: FranchiseDatabase): FranchiseDao =
        database.franchiseDao()

//    @Provides
//    fun provideFranchiseDao(@Named("franchiseDao") database: FranchiseDatabase): FranchiseDao =
//        database.franchiseDao()

//    @Singleton
//    @Provides
//    fun provideDatabaseGames(context: Context): GamesDatabase =
//        Room.databaseBuilder(
//            context,
//            GamesDatabase::class.java, "Games.db"
//        ).fallbackToDestructiveMigration().build()
//
//    @Provides
//    fun provideGamesDao(@Named("gamesDao") databaseGames: GamesDatabase): GamesDao =
//        databaseGames.gamesDao()
}