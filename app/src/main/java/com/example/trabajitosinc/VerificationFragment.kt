package com.example.trabajitosinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

}