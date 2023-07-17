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

        setInfo(view)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setInfo(view: View) {
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
        setNulls(view)

    }

    private fun validateBill(): Boolean {
        return !binding.billingInput.text.isNullOrBlank()
    }

    private fun validateEndDate():Boolean {
        return !binding.endDateText.text.isNullOrBlank()
    }

    private fun setNulls(view: View) {
        when{
            args.status == "Completed" ->{
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.endJobTrabajito.visibility = View.GONE
                binding.endDateText.visibility = View.GONE
                binding.endDateInput.visibility = View.GONE
            }
            args.status == "Pending" && args.hired -> {
                binding.endJobTrabajito.visibility = View.GONE
                binding.billCardTrabajito.visibility = View.GONE
                binding.endDateTrabajito.visibility = View.GONE
                binding.endDateInput.visibility = View.VISIBLE
                binding.endJobTrabajito.visibility = View.GONE
                binding.confirmButtonTrabajito.setOnClickListener {
                    requireView().findNavController().popBackStack()
                }
            }
            args.status == "On Progress" && args.hired -> {
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.BillingField.visibility = View.VISIBLE
                binding.billInfoTrabajito.visibility = View.GONE
                binding.endJobTrabajito.setOnClickListener {
                    requireView().findNavController().navigate(R.id.action_trabajitoFragment_to_trabajitoEndVerificationCode)
                }
            }
            args.status == "Pending" && !args.hired-> {
                binding.endJobTrabajito.visibility = View.GONE
                binding.billCardTrabajito.visibility = View.GONE
                binding.endDateTrabajito.setText("Pending")
                binding.endDateInput.visibility = View.GONE
                binding.endDateText.visibility = View.GONE
                binding.endJobTrabajito.visibility = View.GONE
                binding.confirmButtonTrabajito.visibility = View.GONE
            }
            args.status == "On Progress" && !args.hired-> {
                binding.confirmButtonTrabajito.visibility = View.GONE
                binding.BillingField.visibility = View.GONE
                binding.billInfoTrabajito.text = "Pending"
                binding.endJobTrabajito.setOnClickListener {
                    requireView().findNavController().navigate(R.id.action_trabajitoFragment_to_workerConfirmationNumberFragment)
                }
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