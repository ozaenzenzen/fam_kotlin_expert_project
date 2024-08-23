package com.famandexpertapp1.core.data.source.remote.network

import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ScreenshotResponseModelItem
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("franchises")
    suspend fun getAllFranchise(
        @Header("Client-ID") clientID: String,
        @Header("Authorization") token: String,
        @Header("Accept") accept: String? = "application/json",
        @Body body: RequestBody,
    ): List<ListFranchiseResponseModelItem?>

    @POST("screenshots")
    suspend fun getScreenshot(
        @Header("Client-ID") clientID: String,
        @Header("Authorization") token: String,
        @Header("Accept") accept: String? = "application/json",
        @Body body: RequestBody,
    ): List<ScreenshotResponseModelItem?>

    @POST("games")
    suspend fun getDetailGames(
        @Header("Client-ID") clientID: String,
        @Header("Authorization") token: String,
        @Header("Accept") accept: String? = "application/json",
        @Body body: RequestBody,
    ): List<DetailGamesResponseModelItem?>
}