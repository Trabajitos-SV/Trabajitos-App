package com.example.trabajitosinc.ui.category.recyclerview.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.WorkerByCategoryItemBinding

class ComplexUserRecyclerViewAdapter(
    private val clickListener: (PortfolioModel) -> Unit
): RecyclerView.Adapter<ComplexUserRecyclerViewHolder>() {

    private val portfolios = ArrayList<PortfolioModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplexUserRecyclerViewHolder {
        val binding = WorkerByCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComplexUserRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return portfolios.size
    }

    override fun onBindViewHolder(holder: ComplexUserRecyclerViewHolder, position: Int) {
        val portfolio = portfolios[position]
        holder.bind(portfolio, clickListener)
    }

    fun setData(usersList: List<PortfolioModel>){
        portfolios.clear()
        portfolios.addAll(usersList)
    }

}