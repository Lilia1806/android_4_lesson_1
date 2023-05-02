package com.example.android_4_lesson_1.ui.fragment.anime.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.databinding.FragmentAnimeDetailBinding
import com.example.android_4_lesson_1.extension.setImage
import com.example.android_4_lesson_1.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args: AnimeDetailFragmentArgs by navArgs()

    override fun setupObserves() {
        lifecycleScope.launch{
        viewModel.fetchAnimeDetail(args.id).collect {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    it.data.let { anime ->
                        binding.itemAnimeName.text = anime!!.data.attributes.titles.enJp
                        binding.itemAnimeImage.setImage(anime.data.attributes.posterImage.original)
                        binding.itemAnimePoster.setImage(anime.data.attributes.posterImage.original)
                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                    }
                }
                }
            }
        }
    }
}