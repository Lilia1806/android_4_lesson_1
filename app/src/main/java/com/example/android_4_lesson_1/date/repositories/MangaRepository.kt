package com.example.android_4_lesson_1.date.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android_4_lesson_1.base.BaseRepository
import com.example.android_4_lesson_1.date.remote.apiservce.MangaApiService
import com.example.android_4_lesson_1.date.repositories.pagingources.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSource(mangaApiService)
    }.liveData

    fun fetchMangaDetail(id: String) = doRequest {
        mangaApiService.fetchMangaDetail(id)
    }
}
