package com.example.android_4_lesson_1.models

import com.example.android_4_lesson_1.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("id")
    override val id: String,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("type")
    val type: String
) : IBaseDiffModel
