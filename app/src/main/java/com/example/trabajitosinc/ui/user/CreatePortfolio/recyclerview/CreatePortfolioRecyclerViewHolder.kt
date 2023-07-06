package com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding

class CreatePortfolioRecyclerViewHolder(private val binding : ItemImagePortfolioBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(portfolio: PortfolioModel, clickListener: (PortfolioModel) -> Unit) {
        binding.carouselImageView.setImageResource(portfolio.images)
    }
}