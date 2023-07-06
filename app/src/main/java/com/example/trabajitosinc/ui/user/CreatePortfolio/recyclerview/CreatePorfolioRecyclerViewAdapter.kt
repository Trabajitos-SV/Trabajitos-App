package com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding

class CreatePorfolioRecyclerViewAdapter (
    private val clickListener: (UserModel)-> Unit
): RecyclerView.Adapter<CreatePortfolioRecyclerViewHolder>(){

    private val users = ArrayList<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatePortfolioRecyclerViewHolder {
        val binding  = ItemImagePortfolioBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CreatePortfolioRecyclerViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CreatePortfolioRecyclerViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user,clickListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setData(userList: List<UserModel>){
        users.clear()
        users.addAll(userList)
        notifyDataSetChanged()
    }

}