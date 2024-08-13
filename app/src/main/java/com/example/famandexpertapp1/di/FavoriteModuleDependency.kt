package com.example.famandexpertapp1.di

import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependency {

    fun appUseCase(): AppUseCase
}