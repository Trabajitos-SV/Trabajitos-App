package com.example.trabajitosinc.ui.user.UserInfo.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemRepositoryViewBinding

class UserInfoRecyclerViewHolder (private val binding : ItemRepositoryViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserModel, clickListener: (UserModel) -> Unit) {
    binding.repositoryImageItem.setImageResource(user.image)
    }
}