package com.example.android_4_lesson_1.ui.fragment.anime

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android_4_lesson_1.base.BaseViewModel
import com.example.android_4_lesson_1.date.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime().cachedIn(viewModelScope)
}