package com.example.android_4_lesson_1.ui.fragment.main.home.manga.detail

import com.example.android_4_lesson_1.base.BaseViewModel
import com.example.android_4_lesson_1.date.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : BaseViewModel() {

    fun fetchMangaDetail(id: String) = mangaRepository.fetchMangaDetail(id)
}