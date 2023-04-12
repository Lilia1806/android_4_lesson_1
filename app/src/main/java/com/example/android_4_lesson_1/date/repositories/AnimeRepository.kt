package com.example.android_4_lesson_1.date.repositories

import androidx.lifecycle.liveData
import com.example.android_4_lesson_1.Resource
import com.example.android_4_lesson_1.date.remote.apiservce.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) {

    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(animeApiService.fetchAnime()))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }

//    fun fetchAnimeDetail() = liveData {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(animeApiService.fetchAnimeDetail()))
//        }catch (exception: Exception){
//            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
//        }
//    }
}