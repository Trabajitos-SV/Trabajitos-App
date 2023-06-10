package com.example.trabajitosinc.ui.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trabajitosinc.R
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.FragmentCategoriesBinding
import com.example.trabajitosinc.repositories.CategoryRepository
import com.example.trabajitosinc.ui.category.recyclerview.CategoryRecyclerViewAdapter
import com.example.trabajitosinc.ui.viewmodel.CategoryViewModel
import java.lang.NumberFormatException

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var adapter: CategoryRecyclerViewAdapter

    private val categoryViewModel: CategoryViewModel by activityViewModels {
        CategoryViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)


    }

    private fun showSelectedItem(category: CategoryModel){
        categoryViewModel.setSelected(category)
        Log.d("APP_TAG", category.name)
        //findNavController().navigate(R.id.action_navigation_categories_to_selectedCategoryFragment)
    }

    private fun displayCategories() {
        adapter.setData(categoryViewModel.getCategories())
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerView(view: View){
        binding.categoriesListRecyclerView.layoutManager = GridLayoutManager(view.context, 2)
        //LinearLayoutManager(view.context)
        adapter = CategoryRecyclerViewAdapter {
            showSelectedItem(it)
        }

        binding.categoriesListRecyclerView.adapter = adapter
        displayCategories()
    }

}