package com.example.android_4_lesson_1.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_4_lesson_1.ui.fragment.main.home.anime.AnimeFragment
import com.example.android_4_lesson_1.ui.fragment.main.home.manga.MangaFragment

class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            1 -> MangaFragment()
            else -> MangaFragment()
        }
    }
}