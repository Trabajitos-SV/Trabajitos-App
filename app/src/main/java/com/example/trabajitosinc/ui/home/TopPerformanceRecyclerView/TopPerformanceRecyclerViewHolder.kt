package com.example.trabajitosinc.ui.home.TopPerformanceRecyclerView

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.RepositoryModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemTopPerformanceBinding

class TopPerformanceRecyclerViewHolder (private val binding: ItemTopPerformanceBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind (user  : UserModel, clickListener: (UserModel) -> Unit) {
        binding.userName.text = user.name
        binding.userCategory.text = user.email
        binding.userImage.setImageResource(user.image)


        binding.topPerformanceCardView.setOnClickListener{
            clickListener(user)
        }

    }
}