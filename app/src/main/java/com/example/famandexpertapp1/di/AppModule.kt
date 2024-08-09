package com.example.famandexpertapp1.di

import com.famandexpertapp1.core.domain.usecase.AppInteractor
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideAppUseCase(appInteractor: AppInteractor): AppUseCase
}