package com.famandexpertapp1.core.utils.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverterHelper {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): List<Int?> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Int?>): String {
        return gson.toJson(list)
    }
}