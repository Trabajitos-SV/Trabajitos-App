package com.example.trabajitosinc.ui.home.SuggestedRecyclerView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemSuggestedAssociatesBinding

class SuggestedRecyclerViewHolder(private val binding: ItemSuggestedAssociatesBinding)  : RecyclerView.ViewHolder(binding.root) {

    fun bind (user  : UserModel, clickListener: (UserModel) -> Unit) {
        binding.userNameCard.text = user.name
        binding.userLastnameCard.text = user.name
        //glide
        Glide
            .with(binding.root)
            .load(user.image)
            .into(binding.userImageCard)
        //binding.userImageCard.setImageResource(user.image)


        binding.suggestedAssociatesCard.setOnClickListener{
            Unit
        }

    }

}