package com.example.trabajitosinc.ui.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentTrabajitoBinding

class TrabajitoFragment : Fragment() {

    private lateinit var binding: FragmentTrabajitoBinding

    private val args: TrabajitoFragmentArgs by navArgs()
    private lateinit var currentTrabajito: TrabajitoModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrabajitoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentTrabajito = args.trabajito!!
        setInfo()

    }

    private fun setInfo() {
        binding.startDateTrabajito.setText(currentTrabajito.startDate)
        binding.endDateTrabajito.setText(currentTrabajito.endDate)
        binding.taskDescriptionTrabajito.setText(currentTrabajito.taskDescription)
        binding.billInfoTrabajito.setText(currentTrabajito.bill)
        binding.confirmButtonTrabajito.setOnClickListener{
            it.findNavController().popBackStack()
        }
        binding.endJobTrabajito.setOnClickListener{
            it.findNavController().popBackStack()
        }
    }

}