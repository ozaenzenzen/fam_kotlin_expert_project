package com.famandexpertapp1.core.domain.repository

import com.famandexpertapp1.core.data.Resource
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface IAppRepository {
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
}