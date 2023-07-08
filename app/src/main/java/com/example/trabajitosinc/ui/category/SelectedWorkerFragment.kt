package com.example.trabajitosinc.ui.category

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.UserComplexModel
import com.example.trabajitosinc.data.porfolios
import com.example.trabajitosinc.databinding.FragmentSelectedWorkerBinding
import com.example.trabajitosinc.ui.category.selectedworker.recylcerview.SelectedWorkerRecyclerViewAdapter
import com.example.trabajitosinc.ui.category.selectedworker.viewmodel.SelectedWorkerViewModel
import com.google.android.material.carousel.CarouselLayoutManager

class SelectedWorkerFragment : Fragment() {


    private val selectedWorkerViewModel : SelectedWorkerViewModel by activityViewModels {
        SelectedWorkerViewModel.Factory
    }

    private val myImages = porfolios[0].images.toMutableList()


    private lateinit var adapter: SelectedWorkerRecyclerViewAdapter
    private lateinit var binding: FragmentSelectedWorkerBinding


    private val args : SelectedWorkerFragmentArgs by navArgs()
    private lateinit var selectedWorker : UserComplexModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedWorkerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedWorker = args.worker
        bind(view)

        val images = porfolios[0].images.toMutableList()
        setRecyclerViewImages(images, selectedWorkerViewModel)


    }

    fun setRecyclerViewImages(images: MutableList<String>, viewModel: SelectedWorkerViewModel){
        val carouselLayoutManager = CarouselLayoutManager()
        binding.tienequefuncionarView.layoutManager = carouselLayoutManager

        adapter = SelectedWorkerRecyclerViewAdapter(images){ selectedImage ->
            viewModel.setSelectedImage(selectedImage.toUri())
            adapter.setSelected(selectedImage.toInt())
        }

        binding.tienequefuncionarView.adapter = adapter
        displayImages(myImages)

    }

    private fun displayImages(images: MutableList<String>){

        val selectedImage = selectedWorkerViewModel.getSelectedImage()

        adapter.setData(images)
        adapter.notifyDataSetChanged()

    }



    private fun bind(view: View) {
        binding.workerNameSelectedWorker.text = selectedWorker.name
        binding.descriptionSelectedWorker.text = selectedWorker.portfolio.description
        Glide
            .with(this)
            .load(selectedWorker.portfolio.images[0])
            .into(binding.mainImageWorker)

        binding.floatingActionButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_selectedWorkerFragment_to_scheduleAppointmentFragment)
        }
    }

}