package com.example.trabajitosinc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabajitosinc.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {

    private lateinit var binding : FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }


}