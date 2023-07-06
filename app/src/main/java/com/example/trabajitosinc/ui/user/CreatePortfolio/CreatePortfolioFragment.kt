package com.example.trabajitosinc.ui.user.CreatePortfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentCreatePortfolioBinding
import com.example.trabajitosinc.databinding.ItemImagePortfolioBinding


class CreatePortfolioFragment : Fragment() {



    private lateinit var adapter: ItemImagePortfolioBinding
    private lateinit var binding: FragmentCreatePortfolioBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePortfolioBinding.inflate(inflater, container, false)

        val items = listOf("Carpintero", "Futbolista", "Pintor","Soldador")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item,items)
        binding.dropdownField.setAdapter(adapter)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            findNavController().navigate(R.id.action_createPortfolioFragment_to_navigation_user)
        }
    }

    fun displayIamges(){

    }


}