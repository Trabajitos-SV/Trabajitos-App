package com.example.trabajitosinc.ui.home.SuggestedRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.ItemSuggestedAssociatesBinding


class SuggestedRecyclerViewAdapter (
    private val clickListener: (UserModel) -> Unit
) : RecyclerView.Adapter<SuggestedRecyclerViewHolder>() {

    private val users = ArrayList<UserModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuggestedRecyclerViewHolder {
        val binding =
            ItemSuggestedAssociatesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestedRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: SuggestedRecyclerViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, clickListener)
    }

    fun setData(userList: List<UserModel>) {
        users.clear()
        users.addAll(userList)
    }

}