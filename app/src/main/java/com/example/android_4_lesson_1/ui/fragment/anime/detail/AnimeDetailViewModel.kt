package com.example.android_4_lesson_1.ui.fragment.anime.detail

import com.example.android_4_lesson_1.base.BaseViewModel
import com.example.android_4_lesson_1.date.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnimeDetail(id: String) = animeRepository.fetchAnimeDetail(id)
}