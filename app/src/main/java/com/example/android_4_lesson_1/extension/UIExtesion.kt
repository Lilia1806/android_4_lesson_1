package com.example.android_4_lesson_1.extension

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}