package com.example.trabajitosinc.ui.changepassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentVerificationBinding


class VerificationFragment : Fragment() {



    private lateinit var binding : FragmentVerificationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerificationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_emailFragment)
        }

        binding.verifyButton.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_newPasswordFragment)
        }

    }

}