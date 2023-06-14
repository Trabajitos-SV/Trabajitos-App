package com.example.trabajitosinc.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.trabajitosinc.databinding.FragmentSelectedCategoryBinding
import com.example.trabajitosinc.ui.viewmodel.CategoryViewModel

class SelectedCategoryFragment : Fragment() {

    private lateinit var binding: FragmentSelectedCategoryBinding

    private val categoryViewModel: CategoryViewModel by activityViewModels {
        CategoryViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = categoryViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}