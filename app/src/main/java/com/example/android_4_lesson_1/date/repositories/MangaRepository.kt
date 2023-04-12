package com.example.android_4_lesson_1.date.repositories

import androidx.lifecycle.liveData
import com.example.android_4_lesson_1.Resource
import com.example.android_4_lesson_1.date.remote.apiservce.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) {

    fun fetchManga() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(mangaApiService.fetchManga()))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }

//    fun fetchMangaDetail(id: Int) = liveData {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(mangaApiService.fetchMangaDetail(id)))
//        }catch (exception: Exception){
//            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
//        }
//    }
}