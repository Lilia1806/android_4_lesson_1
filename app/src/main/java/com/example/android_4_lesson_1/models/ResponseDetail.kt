package com.example.android_4_lesson_1.models

import com.google.gson.annotations.SerializedName

data class ResponseDetail(
    @SerializedName("data")
    val data: DataItem
)