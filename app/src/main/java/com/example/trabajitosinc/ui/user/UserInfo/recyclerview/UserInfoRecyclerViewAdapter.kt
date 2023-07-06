package com.example.trabajitosinc.ui.user.UserInfo.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemRepositoryViewBinding

class UserInfoRecyclerViewAdapter (

    private val clickListener: (UserModel)-> Unit
    ): RecyclerView.Adapter<UserInfoRecyclerViewHolder>(){


    private val users = ArrayList<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoRecyclerViewHolder {
        val binding = ItemRepositoryViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserInfoRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserInfoRecyclerViewHolder, position: Int) {
        val user = users [position]
        holder.bind(user,clickListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setData(usersList: List<UserModel>){
        users.clear()
        users.addAll(usersList)
    }


}
