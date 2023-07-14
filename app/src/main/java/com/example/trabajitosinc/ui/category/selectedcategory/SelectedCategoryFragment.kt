package com.example.trabajitosinc.ui.category.selectedcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.databinding.FragmentSelectedCategoryBinding
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst
import com.example.trabajitosinc.ui.category.selectedcategory.recyclerview.PortfolioByCategoryRecyclerViewAdapter
import com.example.trabajitosinc.ui.category.selectedcategory.viewmodel.SelectedCategoryViewModel
import kotlinx.coroutines.launch

class SelectedCategoryFragment : Fragment() {

    private lateinit var binding: FragmentSelectedCategoryBinding
    private lateinit var adapter: PortfolioByCategoryRecyclerViewAdapter
    private var workers: MutableList<FindPortfolioByCategoryIdLitst> = mutableListOf()

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

        lifecycleScope.launch {
            val response =
                selectedCategoryViewModel.getPortfolioByCatergoryRemote(selectedCategory.id, 1)
            when (response) {
                is ApiResponse.Error -> TODO()
                is ApiResponse.ErrorWithMessage -> TODO()
                is ApiResponse.Success -> {
                    workers.clear()
                    workers.addAll(response.data.docs)
                    //Toast.makeText(requireContext(), response.data.docs[0].title, Toast.LENGTH_SHORT).show()
                    setRecyclerView(view)
                }
            }
        }

        setRecyclerView(view)

    }

    private fun showSelectedItem(worker: FindPortfolioByCategoryIdLitst) {
        selectedCategoryViewModel.setSelected(worker)

        var name = worker.user.name
        var workerId = worker._id
        var phone = worker.user.phone
        var email = worker.user.email
        var tittle = worker.title
        var images = worker.uploadedImages.map { it.secureUrl }.toTypedArray()
        var description = worker.description

        val directions = SelectedCategoryFragmentDirections.actionSelectedCategoryFragmentToSelectedWorkerFragment(
             name, workerId, phone.toString(), email, tittle, images, description
        )
        findNavController().navigate(directions)
        Toast.makeText(context, worker.user.name, Toast.LENGTH_SHORT).show()

    }

    private fun displayWorkers() {
        adapter.setData(workers)
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerView(view: View) {
        binding.workersRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PortfolioByCategoryRecyclerViewAdapter {
            showSelectedItem(it)
        }

        binding.workersRecyclerView.adapter = adapter
        displayWorkers()
    }

}