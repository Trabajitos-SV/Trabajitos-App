package com.example.trabajitosinc.ui

import com.example.trabajitosinc.ui.home.HomeViewModel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.FragmentHomeBinding
import com.example.trabajitosinc.databinding.ItemSuggestedAssociatesBinding
import com.example.trabajitosinc.ui.home.CategoriesHomeRecyclerView.CategoriesHomeRecyclerViewAdapter
import com.example.trabajitosinc.ui.home.SuggestedRecyclerView.SuggestedRecyclerViewAdapter
import com.example.trabajitosinc.ui.home.TopPerformanceRecyclerView.TopPerformanceRecyclerViewAdapter

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels {
        HomeViewModel.Factory
    }


    private lateinit var binding : FragmentHomeBinding
    private lateinit var adapter : CategoriesHomeRecyclerViewAdapter
    private lateinit var adapterTopPerformance : TopPerformanceRecyclerViewAdapter
    private lateinit var adapterSuggestedAssociates : SuggestedRecyclerViewAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowForwardCategoriesButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_categories)
        }

        setRecyclerViewCategories(view)

        setRecyclerViewTopPerformance(view)

        setRecyclerViewSuggestedAssociates(view)

    }

    private fun showSelectedItemCategories(category: CategoryModel){
        homeViewModel.setSelectedCategory(category)
        Log.d("APP_TAG", category.name)
        findNavController().navigate(R.id.action_navigation_categories_to_selectedCategoryFragment)
    }

    private fun displayCategories() {
        adapter.setData(homeViewModel.getCategories())
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerViewCategories(view: View){

        binding.categoriesHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        adapter = CategoriesHomeRecyclerViewAdapter {
            showSelectedItemCategories(it)
        }

        binding.categoriesHome.adapter = adapter
        displayCategories()

    }


    private fun showSelectedItemTopPerformance(user: UserModel){
        homeViewModel.setSelectedUser(user)
        Log.d("APP_TAG", user.name)
        findNavController().navigate(R.id.action_navigation_categories_to_selectedCategoryFragment)
    }

    private fun displayUser() {
        adapterTopPerformance.setData(homeViewModel.getUsers())
        adapterTopPerformance.notifyDataSetChanged()

    }

    fun setRecyclerViewTopPerformance(view: View){

        binding.topPerformance.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        adapterTopPerformance = TopPerformanceRecyclerViewAdapter {
            showSelectedItemTopPerformance(it)
        }

        binding.topPerformance.adapter = adapterTopPerformance
        displayUser()

    }


    private fun showSelectedItemSuggestedAssociates(user: UserModel){
        homeViewModel.setSelectedUser(user)
        Log.d("APP_TAG", user.name)
        findNavController().navigate(R.id.action_navigation_categories_to_selectedCategoryFragment)
    }

    private fun displayUserSuggested() {
        adapterSuggestedAssociates.setData(homeViewModel.getUsers())
        adapterSuggestedAssociates.notifyDataSetChanged()

    }

    fun setRecyclerViewSuggestedAssociates(view: View){

        binding.suggestedAssociates.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        adapterSuggestedAssociates = SuggestedRecyclerViewAdapter {
            showSelectedItemSuggestedAssociates(it)
        }

        binding.suggestedAssociates.adapter = adapterSuggestedAssociates
        displayUserSuggested()

    }

}