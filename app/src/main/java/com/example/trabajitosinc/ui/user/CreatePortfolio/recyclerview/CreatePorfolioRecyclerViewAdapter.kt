package com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding


class CreatePorfolioRecyclerViewAdapter(
    private val images: List<String>,
    private val clickListener: (String) -> Unit
): RecyclerView.Adapter<CreatePortfolioRecyclerViewHolder>() {

    private val portfolios = ArrayList<PortfolioModel>()
    private var selectedPosition = RecyclerView.NO_POSITION
    private var lastItemClickListener: (() -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatePortfolioRecyclerViewHolder {
        val binding = ItemImagePortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatePortfolioRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreatePortfolioRecyclerViewHolder, position: Int) {
            val imageUrl = images[position]
            holder.bind(imageUrl, clickListener)

            holder.itemView.isSelected = position == selectedPosition

        // Configurar el clic en el último elemento
        if (position == itemCount - 1) {
            holder.itemView.setOnClickListener {
                lastItemClickListener?.invoke()
            }
        }
    }


    override fun getItemCount(): Int {
        return portfolios[0].images.size
    }

    fun setData(portfolioList: List<PortfolioModel>) {
        portfolios.clear()
        portfolios.addAll(portfolioList)
        notifyDataSetChanged()
    }

    fun setSelected(position: Int) {
        if (position in 0 until portfolios.size) {
            val previousSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
    }

    // Método para obtener la posición de un elemento en función de la imagen seleccionada
    fun getItemPosition(selectedImage: Uri): Int {
        for (i in 0 until portfolios.size) {
            if (portfolios[i].images == selectedImage) {
                return i
            }
        }
        return RecyclerView.NO_POSITION
    }

    fun setLastItemClickListener(listener: () -> Unit) {
        lastItemClickListener = listener
    }


}
