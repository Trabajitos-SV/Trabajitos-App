package com.example.trabajitosinc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    private lateinit var binding: FragmentWelcomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        binding.textSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
        }

        binding.signInButton.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_mainActivity)
        }

    }


}