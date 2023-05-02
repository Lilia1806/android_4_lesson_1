package com.example.android_4_lesson_1.date.remote.apiservce

import com.example.android_4_lesson_1.models.AnimeResponse
import com.example.android_4_lesson_1.models.DataItem
import com.example.android_4_lesson_1.models.ResponseDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): AnimeResponse<DataItem>

    @GET("edge/manga/{id}")
    suspend fun fetchMangaDetail(
        @Path("id") id: String
    ): ResponseDetail
}