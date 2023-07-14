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
import com.example.trabajitosinc.ui.user.portfolio.viewmodel.CreatePortfolioViewModel
import com.example.trabajitosinc.ui.user.portfolio.CreatePortfolioUiStates
import com.google.android.material.carousel.CarouselLayoutManager


class CreatePortfolioFragment : Fragment() {

    private val createPortfolioViewModel: CreatePortfolioViewModel by activityViewModels {
        CreatePortfolioViewModel.Factory
    }

    private val myImages = porfolios[0].images.toMutableList()

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


        setViewModel()
        observeStatus()

    }
    fun setRecyclerViewImages( images: MutableList<String>, viewModel: CreatePortfolioViewModel) {
        val carouselLayoutManager = CarouselLayoutManager()
        binding.carouselRecyclerView.layoutManager = carouselLayoutManager

        adapter = CreatePorfolioRecyclerViewAdapter (images){ selectedImage ->
            viewModel.setSelectedImage(selectedImage.toUri())
            adapter.setSelected(selectedImage.toInt())
        }

        binding.carouselRecyclerView.adapter = adapter
        displayImages(myImages)

        // Detectar el clic en el último elemento del RecyclerView
        adapter.setLastItemClickListener {
            requestPermissions()
        }
    }



    private fun displayImages(images: MutableList<String>) {

        val selectedImage = createPortfolioViewModel.getSelectedImage()
        if (selectedImage != null) {
            val aux = images.size
            images.add(aux-1 ,selectedImage.toString()) // Agregar la imagen seleccionada a la lista de imágenes
            adapter.notifyDataSetChanged()
        }
        adapter.setData(images)
        adapter.notifyDataSetChanged()

        // Verificar si hay una imagen seleccionada y establecerla como seleccionada en el adaptador
        if (selectedImage != null) {
            val selectedPosition = adapter.getItemPosition(selectedImage)
            adapter.setSelected(selectedPosition)

            Toast.makeText(requireContext(), "Imagen seleccionada", Toast.LENGTH_SHORT).show()
        }

    }



    private fun showSelectedItem(portfolio: PortfolioModel) {
        createPortfolioViewModel.setPortfolio(portfolio)
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
            displayImages(myImages)
        }
    }

    private fun setViewModel(){
        binding.viewmodel = createPortfolioViewModel
    }

    private fun observeStatus(){
        createPortfolioViewModel.status.observe(viewLifecycleOwner){status ->
            handleUiStatus(status)
        }
    }


    private fun handleUiStatus(status: CreatePortfolioUiStates){
        when(status){
            is CreatePortfolioUiStates.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }
            is CreatePortfolioUiStates.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is CreatePortfolioUiStates.Success -> {
                createPortfolioViewModel.clearStates()
                createPortfolioViewModel.clearData()
                findNavController().navigate(R.id.action_createPortfolioFragment_to_navigation_user)
            }
            else -> {}
        }
    }

}
