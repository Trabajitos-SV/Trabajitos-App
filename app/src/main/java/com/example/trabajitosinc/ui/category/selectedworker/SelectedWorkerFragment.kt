package com.example.trabajitosinc.ui.category.selectedworker

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
import com.example.trabajitosinc.data.porfolios
import com.example.trabajitosinc.databinding.FragmentSelectedWorkerBinding
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst
import com.example.trabajitosinc.ui.category.selectedworker.recylcerview.SelectedWorkerRecyclerViewAdapter
import com.example.trabajitosinc.ui.category.selectedworker.viewmodel.SelectedWorkerViewModel
import com.google.android.material.carousel.CarouselLayoutManager

class SelectedWorkerFragment : Fragment() {


    private val selectedWorkerViewModel : SelectedWorkerViewModel by activityViewModels {
        SelectedWorkerViewModel.Factory
    }

    private lateinit var adapter: SelectedWorkerRecyclerViewAdapter
    private lateinit var binding: FragmentSelectedWorkerBinding


    private val args : SelectedWorkerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedWorkerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        val imagesList = args.images

        setRecyclerView(view)

        //setRecyclerViewImages(images, selectedWorkerViewModel)

    }

    private fun bind(view: View) {
        Glide
            .with(this)
            .load(args.images[0])
            .into(binding.mainImageWorker)

        binding.floatingActionButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_selectedWorkerFragment_to_scheduleAppointmentFragment)
        }

        binding.workerNameSelectedWorker.text = args.name
        binding.descriptionSelectedWorker.text = args.description

    }

    private fun showSelectedItem(image: String) {
        selectedWorkerViewModel.setSelectedImage(image)
    }

    private fun displayImagesZ(images: Array<String>) {
        adapter.setData(images)
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.tienequefuncionarView.layoutManager = CarouselLayoutManager()

        adapter = SelectedWorkerRecyclerViewAdapter{ _selected ->
            showSelectedItem(_selected)
        }

        binding.tienequefuncionarView.adapter = adapter
        displayImagesZ(args.images)


    }

}