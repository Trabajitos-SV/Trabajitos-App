package com.example.trabajitosinc.ui.history.trabajito

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentTrabajitoBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TrabajitoFragment : Fragment() {

    private lateinit var binding: FragmentTrabajitoBinding

    private val args: TrabajitoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrabajitoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInfo()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setInfo() {
        binding.workerNameTrabajito.text = args.name
        binding.workerLocationTrabajito.text = "Coming soon"
        binding.workerPhoneTrabajito.text = args.phone
        binding.startDateTrabajito.text = shortDate(args.startDate)
        if (args.endDate != "Pending"){
            binding.endDateTrabajito.text = shortDate(args.endDate)
        } else {
            binding.endDateTrabajito.text = args.endDate
        }
        binding.taskDescriptionTrabajito.text = args.description
        binding.billInfoTrabajito.text = "Pending"
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
            args.status == "Completed" ->{
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.endJobTrabajito.visibility = View.GONE
            }
            args.status == "Pending" -> {
                binding.endJobTrabajito.visibility = View.GONE
                binding.billCardTrabajito.visibility = View.GONE
                binding.endDateTrabajito.setText("Pending")
                binding.endDateInput.visibility = View.VISIBLE
                binding.endJobTrabajito.visibility = View.GONE
            }
            args.status == "On Progress" -> {
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.BillingField.visibility = View.VISIBLE
                binding.billInfoTrabajito.visibility = View.GONE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun shortDate(fecha :String): String{
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val shortedDate = LocalDate.parse(fecha, formatter)
        return shortedDate.format(DateTimeFormatter.ISO_DATE)

    }

}