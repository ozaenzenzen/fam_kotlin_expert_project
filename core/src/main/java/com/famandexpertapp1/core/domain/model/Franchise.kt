package com.famandexpertapp1.core.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

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
) : Parcelable {
    // Constructor used for reading from a Parcel
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        updatedAt = parcel.readInt(),
        games = mutableListOf<Int?>().apply {
            parcel.readList(this, Int::class.java.classLoader)
        },
        name = parcel.readString() ?: "",
        checksum = parcel.readString() ?: "",
        createdAt = parcel.readLong(),
        slug = parcel.readString() ?: "",
        url = parcel.readString() ?: "",
        image = parcel.readString(),
        isFavorite = parcel.readByte() != 0.toByte()
    )

    companion object : Parceler<Franchise> {

        // Write the object’s data to the passed-in Parcel
        override fun Franchise.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeInt(updatedAt)
            parcel.writeList(games)
            parcel.writeString(name)
            parcel.writeString(checksum)
            parcel.writeLong(createdAt)
            parcel.writeString(slug)
            parcel.writeString(url)
            parcel.writeString(image)
            parcel.writeByte(if (isFavorite) 1 else 0)
        }

        override fun create(parcel: Parcel): Franchise {
            return Franchise(parcel)
        }
    }
}