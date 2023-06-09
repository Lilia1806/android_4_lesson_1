package com.example.android_4_lesson_1.base

import com.example.android_4_lesson_1.utils.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> T) = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(result()))
        } catch (exception: IOException) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}