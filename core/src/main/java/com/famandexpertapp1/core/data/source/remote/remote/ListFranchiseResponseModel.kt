package com.famandexpertapp1.core.data.source.remote.remote

import com.google.gson.annotations.SerializedName

data class ListFranchiseResponseModelItem(

    @field:SerializedName("updated_at")
    val updatedAt: Int? = null,

    @field:SerializedName("games")
    val games: List<Int?>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("checksum")
    val checksum: String? = null,

    @field:SerializedName("created_at")
    val createdAt: Long? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)
