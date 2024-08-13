package com.famandexpertapp1.core.domain.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Franchise(
    val id: Int,
    val updatedAt: Int,
    val games: List<Int?>,
    val name: String,
    val checksum: String,
    val createdAt: Long,
    val slug: String,
    val url: String,
    var image: String?,
    var isFavorite: Boolean,
) : Parcelable