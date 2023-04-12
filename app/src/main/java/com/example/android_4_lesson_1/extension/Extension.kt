package com.example.android_4_lesson_1.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(uri: String) {
    Glide
        .with(this)
        .load(uri)
        .into(this)
}