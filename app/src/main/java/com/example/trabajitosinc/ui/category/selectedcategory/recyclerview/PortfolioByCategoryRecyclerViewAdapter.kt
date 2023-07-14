package com.example.trabajitosinc.ui.category.selectedcategory.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.WorkerByCategoryItemBinding
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst

class PortfolioByCategoryRecyclerViewAdapter(
    private val clickListener: (FindPortfolioByCategoryIdLitst) -> Unit
): RecyclerView.Adapter<PortfolioByCategoryRecyclerViewHolder>() {

    private val portfolios = ArrayList<FindPortfolioByCategoryIdLitst>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioByCategoryRecyclerViewHolder {
        val binding = WorkerByCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PortfolioByCategoryRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return portfolios.size
    }

    override fun onBindViewHolder(holder: PortfolioByCategoryRecyclerViewHolder, position: Int) {
        val portfolio = portfolios[position]
        holder.bind(portfolio, clickListener)
    }

    fun setData(usersList: List<FindPortfolioByCategoryIdLitst>){
        portfolios.clear()
        portfolios.addAll(usersList)
    }

}