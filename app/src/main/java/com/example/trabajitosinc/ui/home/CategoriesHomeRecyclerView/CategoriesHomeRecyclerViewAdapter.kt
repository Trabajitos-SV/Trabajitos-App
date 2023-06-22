package com.example.trabajitosinc.ui.home.CategoriesHomeRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.ItemCategoryHomeViewBinding


class CategoriesHomeRecyclerViewAdapter (
    private val clickListener: (CategoryModel)-> Unit
): RecyclerView.Adapter<CategoriesHomeRecyclerViewHolder>(){

    private val categories = ArrayList<CategoryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHomeRecyclerViewHolder {
        val binding = ItemCategoryHomeViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesHomeRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesHomeRecyclerViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, clickListener)
    }

    fun setData(categoriesList: List<CategoryModel>){
        categories.clear()
        categories.addAll(categoriesList)
    }
}