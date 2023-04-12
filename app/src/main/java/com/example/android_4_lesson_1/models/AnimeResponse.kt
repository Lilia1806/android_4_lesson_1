package com.example.android_4_lesson_1.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(

    @SerializedName("data")
    val data: List<T>?
)
