package com.famandexpertapp1.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "screenshot_table")
data class ScreenshotEntity(
    @ColumnInfo("game")
    val game: Int,

    @ColumnInfo("width")
    val width: Int,

    @ColumnInfo("checksum")
    val checksum: String,

    @PrimaryKey
    @NonNull
    @ColumnInfo("id")
    val id: Int,

    @ColumnInfo("image_id")
    var imageId: String,

    @ColumnInfo("url")
    var url: String,

    @ColumnInfo("height")
    val height: Int,

    @ColumnInfo("alpha_channel")
    val alphaChannel: Boolean,

    @ColumnInfo("animated")
    val animated: Boolean,
) : Parcelable