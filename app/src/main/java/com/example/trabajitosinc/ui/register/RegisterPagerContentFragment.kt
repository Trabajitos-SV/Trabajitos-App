package com.example.trabajitosinc.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentRegisterPagerContentBinding
import com.example.trabajitosinc.ui.register.RegisterUiStatus
import com.example.trabajitosinc.ui.register.viewmodel.RegisterViewModel


class RegisterPagerContentFragment : Fragment() {

    private val registerViewModel : RegisterViewModel by activityViewModels {
        RegisterViewModel.Factory
    }

    private lateinit var binding : FragmentRegisterPagerContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterPagerContentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_self)
        }


        setViewModel()
        observeStatus()


    }

    private fun setViewModel(){
        binding.viewmodel = registerViewModel
    }

    private fun observeStatus(){
        registerViewModel.status.observe(viewLifecycleOwner){ status ->
            handleUiStatus(status)
        }
    }


    private fun handleUiStatus(status: RegisterUiStatus) {
        when(status) {
            is RegisterUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }
            is RegisterUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is RegisterUiStatus.Success -> {
                registerViewModel.clearStatus()
                registerViewModel.clearData()
                findNavController().navigate(R.id.action_loginFragment_self)
            }

            else -> {}
        }
    }

}