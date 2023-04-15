package com.example.android_4_lesson_1.date.remote.apiservce

import com.example.android_4_lesson_1.models.AnimeResponse
import com.example.android_4_lesson_1.models.DataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): AnimeResponse<DataItem>

//    @GET("manga/{id}")
//    fun fetchMangaDetail(id: Int): AnimeResponse<DataItem>
}