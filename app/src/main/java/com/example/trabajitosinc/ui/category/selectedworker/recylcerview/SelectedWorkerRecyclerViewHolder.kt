package com.example.trabajitosinc.ui.category.selectedworker.recylcerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.databinding.ItemProjectsPortfolioViewBinding

class SelectedWorkerRecyclerViewHolder (private val binding : ItemProjectsPortfolioViewBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind (imageUrl: String, clickListener: (String) -> Unit) {

        Glide.with(binding.root)
            .load(imageUrl)
            .into(binding.carouselProjectsView)

        binding.root.setOnClickListener{
            clickListener(imageUrl)
        }

    }
}