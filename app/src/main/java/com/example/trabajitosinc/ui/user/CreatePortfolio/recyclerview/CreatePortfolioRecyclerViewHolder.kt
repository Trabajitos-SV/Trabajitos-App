import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding

class CreatePortfolioRecyclerViewHolder(private val binding: ItemImagePortfolioBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(portfolio: PortfolioModel, clickListener: (PortfolioModel) -> Unit) {
        Glide.with(binding.root)
            .load(portfolio.images)
            .into(binding.carouselImageView)

        binding.root.setOnClickListener {
            clickListener(portfolio)
        }
    }
}
