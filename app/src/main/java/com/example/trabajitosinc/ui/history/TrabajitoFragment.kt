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
        binding.workerNameTrabajito.setText(currentTrabajito.workerName)
        binding.workerLocationTrabajito.setText(currentTrabajito.workerLocation)
        binding.workerPhoneTrabajito.setText(currentTrabajito.phone)
        binding.startDateTrabajito.setText(currentTrabajito.startDate)
        binding.endDateTrabajito.setText(currentTrabajito.endDate)
        binding.taskDescriptionTrabajito.setText(currentTrabajito.taskDescription)
        binding.billInfoTrabajito.setText(currentTrabajito.bill)
        setNulls()
        binding.confirmButtonTrabajito.setOnClickListener{
            if (validateEndDate()){
                it.findNavController().popBackStack()
            }
        }
        binding.endJobTrabajito.setOnClickListener{
            if (validateBill()){
                //it.findNavController().navigate(R.id.action_trabajitoFragment_to_trabajitoEndVerificationCode)
                it.findNavController().navigate(R.id.action_trabajitoFragment_to_workerConfirmationNumberFragment)
            }
        }
    }

    private fun validateBill(): Boolean {
        return !binding.billingInput.text.isNullOrBlank()
    }

    private fun validateEndDate():Boolean {
        return !binding.endDateText.text.isNullOrBlank()
    }

    private fun setNulls() {
        when{
            currentTrabajito.TrabajitoStatus == "Completed" ->{
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.endJobTrabajito.visibility = View.GONE
            }
            currentTrabajito.TrabajitoStatus == "Pending" -> {
                binding.endJobTrabajito.visibility = View.GONE
                binding.billCardTrabajito.visibility = View.GONE
                binding.endDateTrabajito.setText("Pending")
                binding.endDateInput.visibility = View.VISIBLE
                binding.endJobTrabajito.visibility = View.GONE
            }
            currentTrabajito.TrabajitoStatus == "In Progress" -> {
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.BillingField.visibility = View.VISIBLE
                binding.billInfoTrabajito.visibility = View.GONE
            }
        }
    }

}