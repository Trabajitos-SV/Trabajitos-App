package com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel

class TrabajitoRecyclerViewAdapter(
    var context: Context,
    private val clickListener: (tempRequestModel)-> Unit
): RecyclerView.Adapter<TrabajitoRecyclerViewHolder>() {

    private val trabajitos  = ArrayList<tempRequestModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajitoRecyclerViewHolder {
        val binding = ItemTrabajitoCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrabajitoRecyclerViewHolder(binding, context)
    }

    override fun getItemCount(): Int {
        return trabajitos.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TrabajitoRecyclerViewHolder, position: Int) {
        val trabajito = trabajitos[position]
        holder.bind(trabajito, clickListener)
    }

    fun setData(trabajitosList: List<tempRequestModel>){
        trabajitos.clear()
        trabajitos.addAll(trabajitosList)
    }

}