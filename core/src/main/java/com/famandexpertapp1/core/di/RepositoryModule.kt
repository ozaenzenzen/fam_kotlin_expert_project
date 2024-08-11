package com.famandexpertapp1.core.di

import com.famandexpertapp1.core.data.AppRepository
import com.famandexpertapp1.core.domain.repository.IAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(appRepository: AppRepository): IAppRepository
}