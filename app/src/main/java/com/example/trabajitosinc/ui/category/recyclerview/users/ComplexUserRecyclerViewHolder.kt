package com.example.trabajitosinc.ui.category.recyclerview.users

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserComplexModel
import com.example.trabajitosinc.databinding.WorkerByCategoryItemBinding

class ComplexUserRecyclerViewHolder(private val binding: WorkerByCategoryItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(complexUser: UserComplexModel, clickListener: (UserComplexModel)-> Unit){
        binding.workerNameSelectedCat.text = complexUser.name
        binding.workerCatSelectedCat.text = complexUser.portfolio.category
        binding.workerImageSelectedCat.setImageResource(complexUser.image)

        binding.workerSelectedCatCv.setOnClickListener{
            clickListener(complexUser)
        }
    }

}