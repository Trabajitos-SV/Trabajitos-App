package com.example.trabajitosinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

}