package com.vivu.techrumnews.sdk

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object JsonHelper {
    private var gson = GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create()

    fun toJson(`object`: Any): String {
        return gson!!.toJson(`object`)
    }

    @Throws(NullPointerException::class)
    fun <T> getObject(json: String?, clazz: Class<T>): T {
        return if (json == null || json.isEmpty())
            throw NullPointerException("INPUT IS NULL OR EMPTY")
        else
            gson!!.fromJson(json, clazz)
    }

    fun <T> getObjectNoException(json: String?, clazz: Class<T>): T? {
        if (json == null || json.isEmpty()) {
            return null
        }

        return try {
            gson!!.fromJson(json, clazz)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun <T> getArrayObject(json: String?, list: List<T>): T? {
        if (json == null || json.isEmpty()) {
            return null
        }
        return try {
            gson!!.toJson(json, object : TypeToken<List<T>>() {}.type) as T
        } catch (e: Exception) {
            null
        }
    }
}