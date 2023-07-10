package com.example.trabajitosinc.ui.category.selectedcategory.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.WorkerByCategoryItemBinding

class PortfolioByCategoryRecyclerViewHolder(private val binding: WorkerByCategoryItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(portfolio: PortfolioModel, clickListener: (PortfolioModel)-> Unit){
        binding.workerNameSelectedCat.text = portfolio.user.name
        binding.workerCatSelectedCat.text = portfolio.category
        Glide
            .with(binding.root)
            .load(portfolio.user.image)
            .into(binding.workerImageSelectedCat)
        //binding.workerImageSelectedCat.setImageResource(complexUser.image)

        binding.workerSelectedCatCv.setOnClickListener{
            clickListener(portfolio)
        }
    }

}