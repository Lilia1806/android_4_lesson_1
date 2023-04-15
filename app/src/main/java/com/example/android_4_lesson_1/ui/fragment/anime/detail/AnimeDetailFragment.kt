package com.example.android_4_lesson_1.ui.fragment.anime.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.databinding.FragmentAnimeDetailBinding
import com.example.android_4_lesson_1.extension.setImage
import com.example.android_4_lesson_1.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class AnimeDetailFragment :
//    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {
//
//    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
//    override val viewModel: AnimeDetailViewModel by viewModels()
//    private val args by navArgs<AnimeDetailFragmentArgs>()
//
//    override fun setupObserves() {
//        viewModel.fetchAnimeDetail(args.id).observe(viewLifecycleOwner) {
//            when (it) {
//                is Resource.Error<*> -> {
//                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
//                }
//                is Resource.Loading<*> -> {
//                    Toast.makeText(requireContext(), "no", Toast.LENGTH_SHORT).show()
//                }
//                is Resource.Success<*> -> {
//                    it.data.let { anime ->
//                        binding.itemAnimeDetailName.text = anime!!.data.attributes.titles.enJp
//                        binding.itemAnimeDetailImage.setImage(anime.data.attributes.posterImage.original)
//                        Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//    }
//}
