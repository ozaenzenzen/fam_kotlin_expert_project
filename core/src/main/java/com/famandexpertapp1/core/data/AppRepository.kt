package com.famandexpertapp1.core.data

import com.famandexpertapp1.core.data.source.local.LocalDataSource
import com.famandexpertapp1.core.data.source.remote.RemoteDataSource
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import com.famandexpertapp1.core.domain.repository.IAppRepository
import com.famandexpertapp1.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : IAppRepository {
    override fun getAllFranchise(): Flow<Resource<List<Franchise>>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteFranchise(): Flow<List<Franchise>> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteFranchise(franchise: Franchise, state: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getDetailGames(): Flow<Resource<Games>> {
        TODO("Not yet implemented")
    }

}