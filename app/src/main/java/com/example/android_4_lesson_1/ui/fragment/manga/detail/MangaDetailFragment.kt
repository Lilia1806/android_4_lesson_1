package com.example.android_4_lesson_1.ui.fragment.manga.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.Resource
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MangaDetailFragment {}
//    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {
//
//    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
//    override val viewModel: MangaDetailViewModel by viewModels()
//    private val args by navArgs<MangaDetailFragmentArgs>()
//
//    override fun setupObserves() {
//        viewModel.fetchMangaDetail(args.id).observe(viewLifecycleOwner) {
//            when (it) {
//                is Resource.Error<*> -> {
//                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
//                }
//                is Resource.Loading<*> -> {
//                }
//                is Resource.Success<*> -> {
//                    binding.itemMangaDetailName.text = it.message
//                    binding.itemMangaDetailImage.setImage(it.message.toString())
//                }
//            }
//        }
//    }
//}