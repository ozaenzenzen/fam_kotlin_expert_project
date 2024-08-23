package com.famandexpertapp1.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "franchise_table")
data class FranchiseEntity (
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,

    @ColumnInfo("updated_at")
    val updatedAt: Int,

    @ColumnInfo("games")
    val games: List<Int?>,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("checksum")
    val checksum: String,

    @ColumnInfo("created_at")
    val createdAt: Long,

    @ColumnInfo("slug")
    val slug: String,

    @ColumnInfo("url")
    val url: String,

    @ColumnInfo("image")
    var image: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,
) : Parcelable