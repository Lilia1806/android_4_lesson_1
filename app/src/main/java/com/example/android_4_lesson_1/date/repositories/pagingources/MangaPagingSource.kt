package com.example.android_4_lesson_1.date.repositories.pagingources

import android.net.Uri
import com.example.android_4_lesson_1.base.BasePagingSource
import com.example.android_4_lesson_1.date.remote.apiservce.MangaApiService
import com.example.android_4_lesson_1.models.DataItem

private const val MANGA_STARTING_PAGE_INDEX = 1

class MangaPagingSource(private val mangaService: MangaApiService) : BasePagingSource<DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: MANGA_STARTING_PAGE_INDEX
            val response = mangaService.fetchManga(params.loadSize, nextPage)
            val nextPages =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
