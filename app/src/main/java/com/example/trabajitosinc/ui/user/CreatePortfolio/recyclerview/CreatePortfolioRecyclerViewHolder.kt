package com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding

class CreatePortfolioRecyclerViewHolder(private val binding : ItemImagePortfolioBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserModel, clickListener: (UserModel) -> Unit) {
        binding.carouselImageView.setImageResource(user.image)
    }
}