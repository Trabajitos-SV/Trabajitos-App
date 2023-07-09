package com.example.trabajitosinc.ui.category.selectedworker.recylcerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.databinding.ItemProjectsPortfolioViewBinding

class SelectedWorkerRecyclerViewAdapter (
    private val images : MutableList<String>,
    private val clickListener: (String) -> Unit
): RecyclerView.Adapter<SelectedWorkerRecyclerViewHolder>(){

    private var selectedPosition = RecyclerView.NO_POSITION


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectedWorkerRecyclerViewHolder {
        val binding = ItemProjectsPortfolioViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectedWorkerRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return images.size
    }

    override fun onBindViewHolder(holder: SelectedWorkerRecyclerViewHolder, position: Int) {
        val imageUrl = images[position]
        holder.bind(imageUrl, clickListener)

        holder.itemView.isSelected = position == selectedPosition

        holder.itemView.setOnClickListener {
            Unit
        }
    }

    fun setData(images: List<String>) {
        this.images.clear()
        this.images.addAll(images)
        notifyDataSetChanged()
    }

    fun setSelected(position: Int) {
        if (position in 0 until images.size) {
            val previousSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
    }

}