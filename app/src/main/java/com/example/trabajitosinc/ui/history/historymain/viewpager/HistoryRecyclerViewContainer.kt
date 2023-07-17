package com.example.trabajitosinc.ui.history.historymain.viewpager

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentHistoryRecyclerViewBinding
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.FindTrabajitosRequestsResponse
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel
import com.example.trabajitosinc.ui.history.historymain.HistoryFragmentDirections
import com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview.TrabajitoRecyclerViewAdapter
import com.example.trabajitosinc.ui.history.historymain.viewmodel.HistoryViewModel
import kotlinx.coroutines.launch

class HistoryRecyclerViewContainer : Fragment() {

    private lateinit var binding: FragmentHistoryRecyclerViewBinding
    private lateinit var adapter: TrabajitoRecyclerViewAdapter

    private val viewModel: HistoryViewModel by activityViewModels {
        HistoryViewModel.Factory
    }

    private var trabajitos : MutableList<tempRequestModel> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }


    private val historyViewModel: HistoryViewModel by activityViewModels {
        HistoryViewModel.Factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setRecyclerView(requireActivity().applicationContext)

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {

            when(getInt(ARG_OBJECT)) {
                0 -> {
                    lifecycleScope.launch{
                        val response = viewModel.getMyRequests()

                        when(response){
                            is ApiResponse.Error -> TODO()
                            is ApiResponse.ErrorWithMessage -> TODO()
                            is ApiResponse.Success -> {
                                trabajitos.clear()
                                trabajitos.addAll(response.data.docs)
                                setRecyclerView(requireContext(), 1)
                            }
                        }
                    }
                    setRecyclerView(requireActivity().applicationContext, 8)
                }
                1 -> {
                    lifecycleScope.launch{
                        val response = viewModel.getMyRequests()

                        when(response){
                            is ApiResponse.Error -> TODO()
                            is ApiResponse.ErrorWithMessage -> TODO()
                            is ApiResponse.Success -> {
                                trabajitos.clear()
                                trabajitos.addAll(response.data.docs)
                                setRecyclerView(requireContext(), 1)
                            }
                        }
                    }
                    setRecyclerView(requireContext().applicationContext, 1)
                }

                else -> {}
            }
        }

    }

    private fun showSelectedItem(trabajito: tempRequestModel){
        historyViewModel.setSelected(trabajito)

        //val direction = HistoryFragmentDirections.actionNavigationHistoryToTrabajitoFragment(trabajito)
        //findNavController().navigate(direction)
    }

    private fun displayTrrabajito(page: Int){
        if (page == 1){
            adapter.setData(trabajitos)
            adapter.notifyDataSetChanged()
        }else{
            adapter.setData(trabajitos)
            adapter.notifyDataSetChanged()
        }
    }

    fun setRecyclerView(context: Context,page: Int ){

        binding.myTrabajitosList.layoutManager = LinearLayoutManager(context)

        adapter = TrabajitoRecyclerViewAdapter (context){
            showSelectedItem(it)
        }

        binding.myTrabajitosList.adapter =adapter
        displayTrrabajito(page)
    }

    companion object{
        private const val ARG_OBJECT = "object"
    }

}