package com.example.android_4_lesson_1.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_4_lesson_1.databinding.FragmentHomeBinding
import com.example.android_4_lesson_1.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        Toast.makeText(requireContext(), "home", Toast.LENGTH_SHORT).show()
    }

    private fun initialize() {
        val adapter = ViewPagerAdapter(this@HomeFragment)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "anime"
                }
                1 -> {
                    tab.text = "manga"
                }
            }
        }.attach()
    }
}