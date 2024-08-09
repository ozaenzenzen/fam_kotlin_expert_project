package com.famandexpertapp1.core.data

import com.famandexpertapp1.core.data.source.local.LocalDataSource
import com.famandexpertapp1.core.data.source.remote.RemoteDataSource
import com.famandexpertapp1.core.data.source.remote.network.ApiResponse
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import com.famandexpertapp1.core.domain.repository.IAppRepository
import com.famandexpertapp1.core.utils.AppExecutors
import com.famandexpertapp1.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : IAppRepository {
    override fun getAllFranchise(clientID: String, token: String): Flow<Resource<List<Franchise>>> {
        return object :
            NetworkBoundResource<List<Franchise>, List<ListFranchiseResponseModelItem?>>(
                appExecutors
            ) {
            override fun loadFromDB(): Flow<List<Franchise>> {
                return localDataSource.getAllFranchise()
                    .map { DataMapper.mapFranchiseEntitiesToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ListFranchiseResponseModelItem?>>> =
                remoteDataSource.getAllFranchise(clientID, token)


            override suspend fun saveCallResult(data: List<ListFranchiseResponseModelItem?>) {
                val franchiseList = DataMapper.mapFranchiseResponsesToEntities(data)
                localDataSource.insertFranchise(franchiseList)
            }

            override fun shouldFetch(data: List<Franchise>?): Boolean =
                data == null || data.isEmpty()

        }.asFlow()
    }

    override fun getFavoriteFranchise(): Flow<List<Franchise>> {
        return localDataSource.getFavoriteFranchise().map {
            DataMapper.mapFranchiseEntitiesToDomain(it)
        }
    }

    override fun setFavoriteFranchise(franchise: Franchise, state: Boolean) {
        val franchiseEntity = DataMapper.mapFranchiseDomainToEntity(franchise)
        appExecutors.diskIO()
            .execute { localDataSource.setFavoriteFranchise(franchiseEntity, state) }
    }

    override fun getDetailGames(): Flow<Resource<Games>> {
        TODO("Not yet implemented")
    }

}