package com.example.trabajitosinc.ui.category.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.ItemCategoryCardViewBinding

class CategoryRecyclerViewAdapter(
    private val clickListener: (CategoryModel)-> Unit
): RecyclerView.Adapter<CategoryRecyclerViewHolder>(){

    private val categories = ArrayList<CategoryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryRecyclerViewHolder {
        val binding = ItemCategoryCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryRecyclerViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, clickListener)
    }

    fun setData(categoriesList: List<CategoryModel>){
        categories.clear()
        categories.addAll(categoriesList)
    }
}