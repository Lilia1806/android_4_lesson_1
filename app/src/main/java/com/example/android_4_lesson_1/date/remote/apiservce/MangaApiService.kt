package com.example.android_4_lesson_1.date.remote.apiservce

import com.example.android_4_lesson_1.models.AnimeResponse
import com.example.android_4_lesson_1.models.DataItem
import retrofit2.http.GET

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): AnimeResponse<DataItem>

//    @GET("manga/{id}")
//    fun fetchMangaDetail(id: Int): AnimeResponse<DataItem>
}