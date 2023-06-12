package com.example.trabajitosinc.ui.category.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.ItemCategoryCardViewBinding

class CategoryRecyclerViewHolder(private val binding: ItemCategoryCardViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(category: CategoryModel, clickListener: (CategoryModel)-> Unit){
        binding.categoryNameItem.text = category.name
        binding.categoryImageItem.setImageResource(category.image)

        binding.categoryCardItem.setOnClickListener{
            clickListener(category)
        }
    }
}