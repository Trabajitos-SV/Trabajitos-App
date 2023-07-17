package com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.databinding.ItemTrabajitoCardViewBinding
import com.example.trabajitosinc.network.dto.trabajitos.findJobs.tempJobModel

class JobRecyclerViewAdapter(
    var context: Context,
    private val clickListener: (tempJobModel) -> Unit
): RecyclerView.Adapter<jobRecyclerViewHolder>() {

    private val jobs = ArrayList<tempJobModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): jobRecyclerViewHolder {
        val binding = ItemTrabajitoCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return jobRecyclerViewHolder(binding, context)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: jobRecyclerViewHolder, position: Int) {
        val job = jobs[position]
        holder.bind(job, clickListener)
    }

    fun setData(jobsList: List<tempJobModel>){
        jobs.clear()
        jobs.addAll(jobsList)
    }

}