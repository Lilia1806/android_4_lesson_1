package com.example.android_4_lesson_1.ui.fragment.main.home.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.databinding.FragmentMangaBinding
import com.example.android_4_lesson_1.ui.adapter.MangaAdapter
import com.example.android_4_lesson_1.ui.fragment.main.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment :
    BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private var mangaAdapter = MangaAdapter(this::onItemClick)

    override fun initialize() {
        binding.rvManga.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment2(id)
        )
    }
}
