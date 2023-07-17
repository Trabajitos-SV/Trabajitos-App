package com.example.trabajitosinc.ui.changepassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentPasswordChangedBinding


class PasswordChangedFragment : Fragment() {



    private lateinit var binding : FragmentPasswordChangedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPasswordChangedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backToLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_passwordChangedFragment_to_loginFragment)
        }
    }

}