package com.example.android_4_lesson_1.models

import com.google.gson.annotations.SerializedName

data class SingInModel(
    @SerializedName("small")
    val small: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("large")
    val large: String,
    @SerializedName("tiny")
    val tiny: String,
    @SerializedName("medium")
    val medium: String
)
