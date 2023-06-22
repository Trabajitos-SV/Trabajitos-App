package com.example.trabajitosinc.ui.home.TopPerformanceRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemTopPerformanceBinding

class TopPerformanceRecyclerViewAdapter (
    private val clickListener: (UserModel) -> Unit
) : RecyclerView.Adapter<TopPerformanceRecyclerViewHolder>(){

    private val users = ArrayList<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPerformanceRecyclerViewHolder {
        val binding = ItemTopPerformanceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopPerformanceRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: TopPerformanceRecyclerViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, clickListener)
    }

    fun setData(userList: List<UserModel>){
        users.clear()
        users.addAll(userList)
    }



}