package com.example.android_4_lesson_1.ui.fragment.manga

import androidx.lifecycle.ViewModel
import com.example.android_4_lesson_1.date.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : ViewModel() {

    fun fetchManga() = mangaRepository.fetchManga()
}