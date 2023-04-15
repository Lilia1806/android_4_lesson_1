package com.example.android_4_lesson_1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_4_lesson_1.base.BaseDiffUtilItemCallback
import com.example.android_4_lesson_1.databinding.ItemMangaBinding
import com.example.android_4_lesson_1.models.DataItem

class MangaAdapter : PagingDataAdapter<DataItem, MangaAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(attributes: DataItem) {
            binding.tvManga.text = attributes.attributes.titles.enJp
            Glide.with(binding.itemImageManga).load(attributes.attributes.posterImage.original)
                .into(binding.itemImageManga)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}