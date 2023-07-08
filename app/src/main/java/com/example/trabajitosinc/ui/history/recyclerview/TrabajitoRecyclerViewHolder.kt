package com.example.trabajitosinc.ui.history.recyclerview

import android.content.Context
import android.widget.ExpandableListView.OnChildClickListener
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentHistoryBinding
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding

class  TrabajitoRecyclerViewHolder(private val binding: ItemTrabajitoCardViewBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {

    fun bind(trabajito: TrabajitoModel, clickListener: (TrabajitoModel) -> Unit){
        binding.workerNameItem.text = trabajito.workerName
        binding.workerCategoryItem.text = trabajito.workerCategory
        binding.costItem.text = trabajito.bill
        binding.endDateItem.text = trabajito.endDate
        statusColor(trabajito.TrabajitoStatus)
        binding.statusTxtItem.text = trabajito.TrabajitoStatus


        binding.ttrabajitoCardItem.setOnClickListener{
            clickListener(trabajito)
        }
    }

    private fun statusColor(status: String){
        when (status){
            "Completed" -> binding.statusBgItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.status_completed))
            "In Progress" -> binding.statusBgItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.status_progrss))
            "Pending" -> binding.statusBgItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.status_pending))
            else -> binding.statusBgItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.default_item_color))
        }
    }

}