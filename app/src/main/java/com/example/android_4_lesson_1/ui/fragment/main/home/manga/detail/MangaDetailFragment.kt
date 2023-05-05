package com.example.android_4_lesson_1.ui.fragment.main.home.manga.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.databinding.FragmentMangaDetailBinding
import com.example.android_4_lesson_1.extension.setImage
import com.example.android_4_lesson_1.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchMangaDetail(args.id).collect {
                when (it) {
                    is Resource.Error<*> -> {
                        Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading<*> -> {
                        Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Success<*> -> {
                        it.data.let { manga ->
                            binding.itemMangaName.text = manga!!.data.attributes.titles.enJp
                            binding.itemMangaImage.setImage(manga.data.attributes.posterImage.original)
                            binding.itemMangaPoster.setImage(manga.data.attributes.posterImage.original)
                            binding.itemMangaChapters.text =
                                manga.data.attributes.chapterCount.toString()
                            binding.itemMangaStatus.text = manga.data.attributes.status
                            binding.itemMangaPremiered.text = manga.data.attributes.createdAt
                            binding.itemMangaAgeRating.text = manga.data.attributes.ageRating
                            Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}