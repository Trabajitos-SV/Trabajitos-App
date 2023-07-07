import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding

class CreatePortfolioRecyclerViewHolder(private val binding: ItemImagePortfolioBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String, clickListener: (String) -> Unit) {
        // Cargar la imagen desde la URL utilizando Glide
        Glide.with(binding.root)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    // Manejar el error de carga de la imagen si es necesario
                    Toast.makeText(binding.root.context, "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    // La imagen se cargó correctamente, realizar cualquier acción adicional si es necesario
                    Toast.makeText(binding.root.context, "Imagen cargada correctamente", Toast.LENGTH_SHORT).show()
                    return false
                }
            })
            .into(binding.carouselImageView)

        // Configurar el listener de clic en el itemView
        binding.root.setOnClickListener {
            clickListener(imageUrl)
        }
    }
}
