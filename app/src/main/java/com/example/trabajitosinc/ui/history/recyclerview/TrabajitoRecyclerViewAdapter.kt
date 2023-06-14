package com.example.trabajitosinc.ui.history.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding

class TrabajitoRecyclerViewAdapter(
    private val clickListener: (TrabajitoModel)-> Unit
): RecyclerView.Adapter<TrabajitoRecyclerViewHolder>() {

    private val trabajitos  = ArrayList<TrabajitoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajitoRecyclerViewHolder {
        val binding = ItemTrabajitoCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrabajitoRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return trabajitos.size
    }

    override fun onBindViewHolder(holder: TrabajitoRecyclerViewHolder, position: Int) {
        val trabajito = trabajitos[position]
        holder.bind(trabajito, clickListener)
    }

    fun setData(trabajitosList: List<TrabajitoModel>){
        trabajitos.clear()
        trabajitos.addAll(trabajitosList)
    }

}