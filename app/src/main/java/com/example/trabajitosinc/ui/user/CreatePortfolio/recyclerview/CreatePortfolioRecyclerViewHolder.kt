package com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding

class CreatePortfolioRecyclerViewHolder(private val binding: ItemImagePortfolioBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String, clickListener: (String) -> Unit) {
        // Cargar la imagen desde la URL utilizando Glide
        Glide.with(binding.root)
            .load(imageUrl)
            .into(binding.carouselImageView)

        // Configurar el listener de clic en el itemView
        binding.root.setOnClickListener {
            clickListener(imageUrl)
        }
    }
}
