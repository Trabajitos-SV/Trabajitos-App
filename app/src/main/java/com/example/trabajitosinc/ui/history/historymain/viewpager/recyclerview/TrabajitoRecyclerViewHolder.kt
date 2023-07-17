package com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview

import android.content.Context
import android.os.Build
import android.widget.ExpandableListView.OnChildClickListener
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentHistoryBinding
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class  TrabajitoRecyclerViewHolder(private val binding: ItemTrabajitoCardViewBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(trabajito: tempRequestModel, clickListener: (tempRequestModel) -> Unit){
        binding.workerNameItem.text = trabajito.id_hired.name
        binding.workerCategoryItem.text = "Work"
        binding.costItem.text = "Pending"
        binding.endDateItem.text = shortDate(trabajito.dateInit)
        statusColor(trabajito.status.name)
        binding.statusTxtItem.text = trabajito.status.name



        binding.ttrabajitoCardItem.setOnClickListener{
            clickListener(trabajito)
        }
    }

    private fun statusColor(status: String){
        when (status){
            "Completed" -> {
                binding.statusBgItem.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.status_completed
                    )
                )
                binding.imageTrabajito.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.completed))
            }
            "On Progress" -> {
                binding.statusBgItem.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.status_progrss
                    )
                )
                binding.imageTrabajito.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.in_progress))
            }
            "Pending" -> {
                binding.statusBgItem.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.status_pending
                    )
                )
                binding.imageTrabajito.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.pending))
            }
            else -> binding.statusBgItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.default_item_color))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun shortDate(fecha :String): String{
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val shortedDate = LocalDate.parse(fecha, formatter)
        return shortedDate.format(DateTimeFormatter.ISO_DATE)

    }

}