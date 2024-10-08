@file:Suppress("unused")

package com.example.famandexpertapp1.di

import com.famandexpertapp1.core.domain.usecase.AppInteractor
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideAppUseCase(appInteractor: AppInteractor): AppUseCase
}