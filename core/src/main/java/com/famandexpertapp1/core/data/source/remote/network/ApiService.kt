package com.famandexpertapp1.core.data.source.remote.network

import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModel
import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.GenerateTokenResponseModel
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModel
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("token")
    suspend fun generateToken(
        @Query("client_id") clientID: String,
        @Query("client_secret") clientSecret: String,
        @Query("grant_type") grantType: String? = "client_credentials"
    ): GenerateTokenResponseModel

    @POST("franchises")
    suspend fun getAllFranchise(
        @Header("Client-ID") clientID: String,
        @Header("Authorization") token: String,
        @Header("Accept") accept: String? = "application/json",
        @Body body: RequestBody,
    ): List<ListFranchiseResponseModelItem?>

    @POST("games")
    suspend fun getDetailGames(
        @Header("Client-ID") clientID: String,
        @Header("Authorization") token: String,
        @Header("Accept") accept: String? = "application/json",
    ): DetailGamesResponseModel
}