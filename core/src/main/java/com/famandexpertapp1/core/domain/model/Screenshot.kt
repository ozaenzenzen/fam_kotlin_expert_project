package com.famandexpertapp1.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Screenshot(
    val game: Int? = null,
    val width: Int? = null,
    val checksum: String? = null,
    val id: Int? = null,
    val imageId: String? = null,
    val url: String? = null,
    val height: Int? = null,
    val alphaChannel: Boolean? = null,
    val animated: Boolean? = null
): Parcelable