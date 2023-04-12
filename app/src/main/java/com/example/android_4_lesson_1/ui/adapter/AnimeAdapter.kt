package com.example.android_4_lesson_1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_4_lesson_1.base.BaseDiffUtilItemCallback
import com.example.android_4_lesson_1.databinding.ItemAnimeBinding
import com.example.android_4_lesson_1.models.DataItem

class AnimeAdapter : ListAdapter<DataItem, AnimeAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(attributes: DataItem) {
            binding.tvAnime.text = attributes.attributes.titles.enJp
            Glide.with(binding.imageAnime).load(attributes.attributes.posterImage.original)
                .into(binding.imageAnime)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}