package com.example.android_4_lesson_1.ui.fragment.anime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.Resource
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.databinding.FragmentAnimeBinding
import com.example.android_4_lesson_1.ui.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment :
    BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private var animeAdapter = AnimeAdapter()

    override fun initialize() {
        binding.rvAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {
                }
                is Resource.Success<*> -> {
                    it.data?.let { data ->
                        animeAdapter.submitList(data.data)
                    }
                }
            }
        }
    }

//    private fun onItemClick(id: Int) {
//        findNavController().navigate(
//            AnimeFragmentDirections.actionAnimeFragmentToAnimeDetailFragment(id)
//        )
//    }
}