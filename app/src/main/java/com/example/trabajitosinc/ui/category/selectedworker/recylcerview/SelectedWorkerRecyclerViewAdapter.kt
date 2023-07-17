package com.example.trabajitosinc.ui.category.selectedworker.recylcerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.databinding.ItemProjectsPortfolioViewBinding

class SelectedWorkerRecyclerViewAdapter (
    private val clickListener: (String) -> Unit
): RecyclerView.Adapter<SelectedWorkerRecyclerViewHolder>(){

    private val allImages = ArrayList<String>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectedWorkerRecyclerViewHolder {
        val binding = ItemProjectsPortfolioViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectedWorkerRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectedWorkerRecyclerViewHolder, position: Int) {
        val image = allImages[position]
        holder.bind(image, clickListener)
    }

    override fun getItemCount(): Int {
        return allImages.size
    }

    fun setData(imagesList: Array<String>){
        allImages.clear()
        allImages.addAll(imagesList)
    }

}