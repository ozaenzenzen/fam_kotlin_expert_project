package com.famandexpertapp1.core.data.source.remote.remote

import com.google.gson.annotations.SerializedName

data class GenerateTokenResponseModel(
    @field:SerializedName("access_token")
    val accessToken: String? = null,

    @field:SerializedName("token_type")
    val tokenType: String? = null,

    @field:SerializedName("expires_in")
    val expiresIn: Int? = null
)
