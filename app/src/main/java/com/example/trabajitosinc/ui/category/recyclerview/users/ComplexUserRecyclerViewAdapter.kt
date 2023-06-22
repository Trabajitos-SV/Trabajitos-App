package com.example.trabajitosinc.ui.category.recyclerview.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserComplexModel
import com.example.trabajitosinc.databinding.WorkerByCategoryItemBinding

class ComplexUserRecyclerViewAdapter(
    private val clickListener: (UserComplexModel) -> Unit
): RecyclerView.Adapter<ComplexUserRecyclerViewHolder>() {

    private val complexUsers = ArrayList<UserComplexModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplexUserRecyclerViewHolder {
        val binding = WorkerByCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComplexUserRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return complexUsers.size
    }

    override fun onBindViewHolder(holder: ComplexUserRecyclerViewHolder, position: Int) {
        val complexUser = complexUsers[position]
        holder.bind(complexUser, clickListener)
    }

    fun setData(usersList: List<UserComplexModel>){
        complexUsers.clear()
        complexUsers.addAll(usersList)
    }

}