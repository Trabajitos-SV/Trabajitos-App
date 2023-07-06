
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding
import com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview.CreatePortfolioRecyclerViewHolder

class CreatePorfolioRecyclerViewAdapter(
    private val clickListener: (PortfolioModel) -> Unit
): RecyclerView.Adapter<CreatePortfolioRecyclerViewHolder>() {

    private val portfolios = ArrayList<PortfolioModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatePortfolioRecyclerViewHolder {
        val binding = ItemImagePortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatePortfolioRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreatePortfolioRecyclerViewHolder, position: Int) {
            val portfolio = portfolios[position]
            holder.bind(portfolio, clickListener)
        }


    override fun getItemCount(): Int {
        return portfolios.size
    }

    fun setData(portfolioList: List<PortfolioModel>) {
        portfolios.clear()
        portfolios.addAll(portfolioList)
        notifyDataSetChanged()
    }

}
