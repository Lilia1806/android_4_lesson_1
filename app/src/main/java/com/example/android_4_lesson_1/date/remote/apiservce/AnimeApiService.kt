package com.example.android_4_lesson_1.date.remote.apiservce

import com.example.android_4_lesson_1.models.AnimeResponse
import com.example.android_4_lesson_1.models.DataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): AnimeResponse<DataItem>

//    @GET("anime/{id}")
//     fun fetchAnimeDetail( @Path("id") id: String): AnimeResponse<DataItem>
}