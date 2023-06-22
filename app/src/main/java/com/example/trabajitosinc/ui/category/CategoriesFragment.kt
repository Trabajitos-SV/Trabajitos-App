package com.example.trabajitosinc.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.databinding.FragmentCategoriesBinding
import com.example.trabajitosinc.ui.category.recyclerview.categories.CategoryRecyclerViewAdapter
import com.example.trabajitosinc.ui.viewmodel.CategoryViewModel

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

        val direction = CategoriesFragmentDirections.actionNavigationCategoriesToSelectedCategoryFragment(category)
        findNavController().navigate(direction)
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