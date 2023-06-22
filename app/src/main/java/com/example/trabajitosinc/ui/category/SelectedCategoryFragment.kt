package com.example.trabajitosinc.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.FragmentSelectedCategoryBinding

class SelectedCategoryFragment : Fragment() {

    private lateinit var binding: FragmentSelectedCategoryBinding

    private val args: SelectedCategoryFragmentArgs by navArgs()
    private lateinit var selectedCategory: CategoryModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectedCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedCategory = args.category!!

        binding.selectedCategoryTittle.text = selectedCategory.name
        binding.imageView2.setImageResource(selectedCategory.image)
    }

}