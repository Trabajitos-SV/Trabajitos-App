package com.example.trabajitosinc.ui.history.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentHistoryBinding
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding

class TrabajitoRecyclerViewHolder(private val binding: ItemTrabajitoCardViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(trabajito: TrabajitoModel, clickListener: (TrabajitoModel) -> Unit){
        binding.workerNameItem.text = trabajito.workerName
        binding.workerCategoryItem.text = trabajito.workerCategory
        binding.costItem.text = trabajito.bill
        binding.endDateItem.text = trabajito.endDate
        //binding.statusBgItem.setCardBackgroundColor()
        //TODO: hacer funcion que cambie de color segun estado
        binding.statusTxtItem.text = trabajito.TrabajitoStatus


        binding.ttrabajitoCardItem.setOnClickListener{
            clickListener(trabajito)
        }
    }

}