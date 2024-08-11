package com.famandexpertapp1.core.domain.usecase

import com.famandexpertapp1.core.data.Resource
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getAllFranchise(
        clientID: String,
        token: String,
    ): Flow<Resource<List<Franchise>>>

    fun getFavoriteFranchise(): Flow<List<Franchise>>
    fun setFavoriteFranchise(franchise: Franchise, state: Boolean)
    fun getDetailGames(
        clientID: String,
        token: String,
    ): Flow<Resource<List<Games>>>

    fun getToken(): Flow<String>
    fun setToken(value: String)
}