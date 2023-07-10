package com.example.trabajitosinc.ui.category.selectedcategory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.FragmentSelectedCategoryBinding
import com.example.trabajitosinc.ui.category.selectedcategory.recyclerview.ComplexUserRecyclerViewAdapter
import com.example.trabajitosinc.ui.category.selectedcategory.viewmodel.SelectedCategoryViewModel

class SelectedCategoryFragment : Fragment() {

    private lateinit var binding: FragmentSelectedCategoryBinding
    private lateinit var adapter: ComplexUserRecyclerViewAdapter

    private val selectedCategoryViewModel: SelectedCategoryViewModel by activityViewModels {
        SelectedCategoryViewModel.Factory
    }

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
        selectedCategory = args.category

        binding.selectedCategoryTittle.text = selectedCategory.name
        binding.imageView2.setImageResource(selectedCategory.image)

        setRecyclerView(view)

    }

    private fun showSelectedItem(worker: PortfolioModel){
        selectedCategoryViewModel.setSelected(worker)

        val directions =
            SelectedCategoryFragmentDirections.actionSelectedCategoryFragmentToSelectedWorkerFragment(
                worker
            )
        findNavController().navigate(directions)

    }

    private fun displayWorkers() {
        adapter.setData(selectedCategoryViewModel.getPortfolioByCategory(args.category.name))
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerView(view: View){
        binding.workersRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ComplexUserRecyclerViewAdapter{
            showSelectedItem(it)
        }

        binding.workersRecyclerView.adapter = adapter
        displayWorkers()
    }

}