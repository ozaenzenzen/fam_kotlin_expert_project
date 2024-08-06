package com.famandexpertapp1.core.domain.usecase

import com.famandexpertapp1.core.data.Resource
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getAllFranchise(): Flow<Resource<List<Franchise>>>
    fun getFavoriteFranchise(): Flow<List<Franchise>>
    fun setFavoriteFranchise(franchise: Franchise, state: Boolean)
    fun getDetailGames(): Flow<Resource<Games>>
}