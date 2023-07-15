package com.example.trabajitosinc.ui.user.UserInfo.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemRepositoryViewBinding

class UserInfoRecyclerViewHolder (private val binding : ItemRepositoryViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserModel, clickListener: (UserModel) -> Unit) {
        /*Glide
            .with(binding.root)
            .load(user.image[2])
            .into(binding.repositoryImageItem)*/
    //binding.repositoryImageItem.setImageResource(user.image)
    }
}