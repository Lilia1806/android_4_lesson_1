package com.example.android_4_lesson_1.date.remote.apiservce

import com.example.android_4_lesson_1.models.AnimeResponse
import com.example.android_4_lesson_1.models.DataItem
import retrofit2.http.GET

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): AnimeResponse<DataItem>

//    @GET("anime/{id}")
//     fun fetchAnimeDetail(): AnimeResponse<DataItem>
}