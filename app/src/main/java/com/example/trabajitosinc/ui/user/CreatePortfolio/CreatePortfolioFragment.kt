package com.example.trabajitosinc.ui.user.CreatePortfolio
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.data.porfolios
import com.example.trabajitosinc.databinding.FragmentCreatePortfolioBinding
import com.example.trabajitosinc.ui.user.CreatePortfolio.recyclerview.CreatePorfolioRecyclerViewAdapter
import com.google.android.material.carousel.CarouselLayoutManager


class CreatePortfolioFragment : Fragment() {

    private val createPortfolioViewModel: CreatePortfolioViewModel by activityViewModels {
        CreatePortfolioViewModel.Factory
    }

    private lateinit var adapter: CreatePorfolioRecyclerViewAdapter
    private lateinit var binding: FragmentCreatePortfolioBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePortfolioBinding.inflate(inflater, container, false)

        val items = listOf("Carpintero", "Futbolista", "Pintor", "Soldador")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        binding.dropdownField.setAdapter(adapter)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            findNavController().navigate(R.id.action_createPortfolioFragment_to_navigation_user)
        }

        val images = porfolios[0].images.toMutableList()
        setRecyclerViewImages(images, createPortfolioViewModel)
    }

    fun setRecyclerViewImages( images: MutableList<String>, viewModel: CreatePortfolioViewModel) {
        val carouselLayoutManager = CarouselLayoutManager()
        binding.carouselRecyclerView.layoutManager = carouselLayoutManager

        adapter = CreatePorfolioRecyclerViewAdapter (images){ selectedImage ->
            viewModel.setSelectedImage(selectedImage.toUri())
            adapter.setSelected(selectedImage.toInt())
        }

        binding.carouselRecyclerView.adapter = adapter
        displayImages(porfolios[0])

        // Detectar el clic en el último elemento del RecyclerView
        adapter.setLastItemClickListener {
            requestPermissions()
        }
    }



    private fun displayImages(portfolio: PortfolioModel) {
        val images = portfolio.images.toMutableList()
        adapter.setData(images)
        adapter.notifyDataSetChanged()

        // Verificar si hay una imagen seleccionada y establecerla como seleccionada en el adaptador
        val selectedImage = createPortfolioViewModel.getSelectedImage()
        if (selectedImage != null) {
            val selectedPosition = adapter.getItemPosition(selectedImage)
            adapter.setSelected(selectedPosition)

            Toast.makeText(requireContext(), "Imagen seleccionada", Toast.LENGTH_SHORT).show()
        }

    }



    private fun showSelectedItem(portfolio: PortfolioModel) {
        createPortfolioViewModel.setSelectedPortfolio(portfolio)
    }

    private fun requestPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(
                    requireContext(),android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    pickPhotoFromGallery()
            }
                else -> requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }else{
            pickPhotoFromGallery()
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
            isGranted ->
                if(!isGranted){
                    pickPhotoFromGallery()
                }else{
                    Toast.makeText(requireContext(),"You need to enable permissions", Toast.LENGTH_SHORT).show()
                }
    }


    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }

    private val startForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data?.data
            // Guardar la imagen seleccionada en el ViewModel
            createPortfolioViewModel.setSelectedImage(data)
            // Mostrar la imagen en el RecyclerView
            displayImages(porfolios[0])
        }
    }

}
