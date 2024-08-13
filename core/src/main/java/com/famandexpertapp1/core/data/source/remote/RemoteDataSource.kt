package com.famandexpertapp1.core.data.source.remote

import android.util.Log
import com.famandexpertapp1.core.data.source.remote.network.ApiResponse
import com.famandexpertapp1.core.data.source.remote.network.ApiService
import com.famandexpertapp1.core.data.source.remote.remote.DetailGamesResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ListFranchiseResponseModelItem
import com.famandexpertapp1.core.data.source.remote.remote.ScreenshotResponseModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
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
                Log.e("responseLog", "response $response")
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

    suspend fun getScreenshot(
        clientID: String,
        token: String,
        gamesID: String?,
    ): Flow<ApiResponse<List<ScreenshotResponseModelItem?>>> {
        return flow {
            try {
                val reqBody = if (gamesID == null) {
                    RequestBody.create(
                        "text/plain".toMediaTypeOrNull(),
                        "fields checksum,created_at,games,name,slug,updated_at,url;",
                    )
                } else {
                    RequestBody.create(
                        "text/plain".toMediaTypeOrNull(),
                        "fields alpha_channel,animated,checksum,game,height,image_id,url,width; where id = $gamesID;",
                    )
                }
                val response = apiService.getScreenshot(clientID, token, body = reqBody)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Error getScreenshot", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailGames(
        clientID: String,
        token: String,
        gamesID: String?,
    ): Flow<ApiResponse<List<DetailGamesResponseModelItem?>>> {
        return flow {
            try {
                val reqBody = if (gamesID == null) {
                    RequestBody.create(
                        "text/plain".toMediaTypeOrNull(),
                        "fields age_ratings,aggregated_rating,aggregated_rating_count,alternative_names,artworks,bundles,category,checksum,collection,collections,cover,created_at,dlcs,expanded_games,expansions,external_games,first_release_date,follows,forks,franchise,franchises,game_engines,game_localizations,game_modes,genres,hypes,involved_companies,keywords,language_supports,multiplayer_modes,name,parent_game,platforms,player_perspectives,ports,rating,rating_count,release_dates,remakes,remasters,screenshots,similar_games,slug,standalone_expansions,status,storyline,summary,tags,themes,total_rating,total_rating_count,updated_at,url,version_parent,version_title,videos,websites;",
                    )
                } else {
                    RequestBody.create(
                        "text/plain".toMediaTypeOrNull(),
                        "fields age_ratings,aggregated_rating,aggregated_rating_count,alternative_names,artworks,bundles,category,checksum,collection,collections,cover,created_at,dlcs,expanded_games,expansions,external_games,first_release_date,follows,forks,franchise,franchises,game_engines,game_localizations,game_modes,genres,hypes,involved_companies,keywords,language_supports,multiplayer_modes,name,parent_game,platforms,player_perspectives,ports,rating,rating_count,release_dates,remakes,remasters,screenshots,similar_games,slug,standalone_expansions,status,storyline,summary,tags,themes,total_rating,total_rating_count,updated_at,url,version_parent,version_title,videos,websites; where id = $gamesID;",
                    )
                }
                val response = apiService.getDetailGames(clientID, token, body = reqBody)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Error getDetailGames", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}