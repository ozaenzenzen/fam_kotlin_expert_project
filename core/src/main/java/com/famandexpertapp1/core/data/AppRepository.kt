package com.famandexpertapp1.core.data

import android.util.Log
import com.famandexpertapp1.core.data.source.local.LocalDataSource
import com.famandexpertapp1.core.data.source.remote.RemoteDataSource
import com.famandexpertapp1.core.data.source.remote.network.ApiResponse
import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ScreenshotResponseModelItem
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import com.famandexpertapp1.core.domain.model.Screenshot
import com.famandexpertapp1.core.domain.repository.IAppRepository
import com.famandexpertapp1.core.utils.AppExecutors
import com.famandexpertapp1.core.utils.DataMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("SameReturnValue")
@Singleton
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
                data.isNullOrEmpty()

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

    override fun getDetailGames(
        clientID: String,
        token: String,
        gamesID: String?,
    ): Flow<Resource<List<Games>>> {
        return object :
            NetworkBoundResource<List<Games>, List<DetailGamesResponseModelItem?>>(
                appExecutors
            ) {
            override fun loadFromDB(): Flow<List<Games>> {
                return localDataSource.getGames(gamesID ?: "223112")
                    .map {
                        DataMapper.mapGamesEntitiesToDomain(it)
                    }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<DetailGamesResponseModelItem?>>> {
                return remoteDataSource.getDetailGames(clientID, token, gamesID)
            }

            override suspend fun saveCallResult(data: List<DetailGamesResponseModelItem?>) {
                val gamesList = DataMapper.mapGamesResponsesToEntities(data)
                localDataSource.insertGames(gamesList)
            }

            override fun shouldFetch(data: List<Games>?): Boolean {
                Log.d("ShouldFetch1", "${data.isNullOrEmpty()}")
                return true
            }
        }.asFlow()
    }

    override fun getToken(): Flow<String> {
        val dataToken = localDataSource.getToken().map { value ->
            value.toString()
        }
        return dataToken
    }

    override fun setToken(value: String) {
        appExecutors.diskIO()
            .execute {
                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.setToken(value)
                }
//                runBlocking {
//                    localDataSource.setToken(value)
//                }
            }
    }

    override fun getScreenshot(
        clientID: String,
        token: String,
        gamesID: String,
    ): Flow<Resource<List<Screenshot>>> {
        return object : NetworkBoundResource<List<Screenshot>, List<ScreenshotResponseModelItem?>>(
            appExecutors
        ) {
            override fun loadFromDB(): Flow<List<Screenshot>> {
                return localDataSource.getScreenshotSingleData(gamesID)
                    .map {
                        DataMapper.mapScreenshotEntitiesToDomain(it)
                    }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ScreenshotResponseModelItem?>>> {
                return remoteDataSource.getScreenshot(
                    clientID = clientID,
                    token = token,
                    gamesID = gamesID,
                )
            }

            override suspend fun saveCallResult(data: List<ScreenshotResponseModelItem?>) {
                val screenshotList = DataMapper.mapScreenshotResponsesToEntities(data)
                localDataSource.insertScreenshot(screenshotList)
            }

            override fun shouldFetch(data: List<Screenshot>?): Boolean {
                return data.isNullOrEmpty()
            }

        }.asFlow()
    }
}