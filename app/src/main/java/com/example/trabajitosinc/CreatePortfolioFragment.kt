package com.example.trabajitosinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.trabajitosinc.databinding.FragmentCreatePortfolioBinding


class CreatePortfolioFragment : Fragment() {


    private lateinit var binding: FragmentCreatePortfolioBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePortfolioBinding.inflate(inflater, container, false)

        val items = listOf("Carpintero", "Futbolista", "Pintor","Soldador")
        val adapter = ArrayAdapter(requireContext(),R.layout.list_item,items)
        binding.dropdownField.setAdapter(adapter)

        return binding.root

    }

}