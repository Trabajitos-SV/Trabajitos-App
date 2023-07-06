package com.example.trabajitosinc.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.UserComplexModel
import com.example.trabajitosinc.databinding.FragmentSelectedWorkerBinding

class SelectedWorkerFragment : Fragment() {

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
        bind()

    }

    private fun bind() {
        binding.workerNameSelectedWorker.text = selectedWorker.name
        binding.descriptionSelectedWorker.text = selectedWorker.portfolio.description
        Glide
            .with(this)
            .load(selectedWorker.portfolio.images[0])
            .into(binding.mainImageWorker)
    }

}