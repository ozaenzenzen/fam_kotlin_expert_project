package com.example.famandexpertapp1.di

import com.famandexpertapp1.core.domain.usecase.AppInteractor
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideAppUseCase(appInteractor: AppInteractor): AppUseCase
}