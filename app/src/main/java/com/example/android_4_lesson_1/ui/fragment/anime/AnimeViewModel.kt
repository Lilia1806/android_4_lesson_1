package com.example.android_4_lesson_1.ui.fragment.anime

import androidx.lifecycle.ViewModel
import com.example.android_4_lesson_1.date.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime()
}