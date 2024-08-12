package com.famandexpertapp1.core.data.source.remote

import android.util.Log
import com.famandexpertapp1.core.data.source.remote.network.ApiResponse
import com.famandexpertapp1.core.data.source.remote.network.ApiService
import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
//    companion object {
//        @Volatile
//        private var instance: RemoteDataSource? = null
//
//        fun getInstance(service: ApiService): RemoteDataSource =
//            instance ?: synchronized(this) {
//                instance ?: RemoteDataSource(service)
//            }
//    }

//    suspend fun generateToken(
//        clientID: String,
//        clientSecret: String,
//    ): Flow<ApiResponse<GenerateTokenResponseModel>> {
//        return flow {
//            try {
//                val response = apiService.generateToken(
//                    clientID = clientID,
//                    clientSecret = clientSecret,
//                )
//                if (response.tokenType != null) {
//                    emit(ApiResponse.Success(response))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//                Log.e("generateToken", e.toString())
//            }
//        }.flowOn(Dispatchers.IO)
//    }

    suspend fun getAllFranchise(
        clientID: String,
        token: String,
    ): Flow<ApiResponse<List<ListFranchiseResponseModelItem?>>> {
        return flow {
            try {
                val reqBody = RequestBody.create(
                    "text/plain".toMediaTypeOrNull(),
                    "fields checksum,created_at,games,name,slug,updated_at,url;",
                )
                val response = apiService.getAllFranchise(
                    clientID,
                    token,
                    "application/json",
                    reqBody,
                    )
                Log.e("responseLog", "response ${response}")
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Error getAllFranchise", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailGames(
        clientID: String,
        token: String,
    ): Flow<ApiResponse<List<DetailGamesResponseModelItem?>>> {
        return flow {
            try {
                val response = apiService.getDetailGames(clientID, token)
                val dataArray = response.detailGamesResponseModel
                if (dataArray!!.isNotEmpty()) {
                    emit(ApiResponse.Success(response.detailGamesResponseModel))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}