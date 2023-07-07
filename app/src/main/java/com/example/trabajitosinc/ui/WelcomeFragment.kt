package com.example.trabajitosinc.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentWelcomeBinding
import com.example.trabajitosinc.util.PreferenceHelper
import com.example.trabajitosinc.util.PreferenceHelper.set


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
            goToHome()
            //
        }

    }

    private fun goToHome() {
        val i = Intent(context, TrabajitosActivity::class.java)
        creteSessionPreferences()
        startActivity(i)
        requireActivity().finish()
    }
    private fun creteSessionPreferences() {
        val preferences = PreferenceHelper.defaultPrefs(requireContext())
        preferences["session"] = true
    }

}