package com.example.android_4_lesson_1.date.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android_4_lesson_1.base.BaseRepository
import com.example.android_4_lesson_1.date.remote.apiservce.AnimeApiService
import com.example.android_4_lesson_1.date.repositories.pagingources.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSource(animeApiService)
    }.liveData

//    fun fetchAnimeDetail(id: String) = doRequest {
//        animeApiService.fetchAnimeDetail(id)
//    }
}
