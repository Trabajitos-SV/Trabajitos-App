package com.example.trabajitosinc.ui.home.CategoriesHomeRecyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.ItemCategoryHomeViewBinding


class CategoriesHomeRecyclerViewHolder (private val binding : ItemCategoryHomeViewBinding ): RecyclerView.ViewHolder(binding.root) {

    fun bind (category: CategoryModel, clickListener: (CategoryModel) -> Unit) {

        binding.categoryImageHomeItem.setImageResource(category.image)
        binding.categoryNameHomeItem.text = category.name


        binding.categoryHomeItem.setOnClickListener{
            Unit
        }

    }


}