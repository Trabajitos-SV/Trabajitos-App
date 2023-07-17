package com.example.trabajitosinc.ui.category.selectedcategory.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.databinding.WorkerByCategoryItemBinding
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst

class PortfolioByCategoryRecyclerViewHolder(private val binding: WorkerByCategoryItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(portfolio: FindPortfolioByCategoryIdLitst, clickListener: (FindPortfolioByCategoryIdLitst)-> Unit){

        binding.workerNameSelectedCat.text = portfolio.user.name
        binding.workerCatSelectedCat.text = portfolio.category.name
        Glide
            .with(binding.root)
            .load(portfolio.uploadedImages[0].secureUrl)
            .into(binding.workerImageSelectedCat)
        //binding.workerImageSelectedCat.setImageResource(complexUser.image)

        binding.workerSelectedCatCv.setOnClickListener{
            clickListener(portfolio)
        }
    }
    private fun comesImage() {

    }

}