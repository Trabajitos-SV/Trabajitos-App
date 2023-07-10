package com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding

class TrabajitoRecyclerViewAdapter(
    var context: Context,
    private val clickListener: (TrabajitoModel)-> Unit
): RecyclerView.Adapter<TrabajitoRecyclerViewHolder>() {

    private val trabajitos  = ArrayList<TrabajitoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajitoRecyclerViewHolder {
        val binding = ItemTrabajitoCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrabajitoRecyclerViewHolder(binding, context)
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