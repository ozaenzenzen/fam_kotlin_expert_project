package com.famandexpertapp1.core.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverterHelper {
//    @TypeConverter
//    fun fromListIntToString(intList: List<Int>): String = intList.toString()
//    @TypeConverter
//    fun toListIntFromString(stringList: String): List<Int> {
//        val result = ArrayList<Int>()
//        val split =stringList.replace("[","").replace("]","").replace(" ","").split(",")
//        for (n in split) {
//            try {
//                result.add(n.toInt())
//            } catch (e: Exception) {
//
//            }
//        }
//        return result
//    }

    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return gson.toJson(list)
    }
}