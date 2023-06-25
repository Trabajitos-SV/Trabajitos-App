package com.example.trabajitosinc.ui.history

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentHistoryRecyclerViewBinding
import com.example.trabajitosinc.ui.history.recyclerview.TrabajitoRecyclerViewAdapter
import com.example.trabajitosinc.ui.viewmodel.HistoryViewModel

class HistoryRecyclerViewContainer : Fragment() {

    private lateinit var binding: FragmentHistoryRecyclerViewBinding
    private lateinit var adapter: TrabajitoRecyclerViewAdapter



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

            val league = when(getInt(ARG_OBJECT)) {
                0 -> {
                    setRecyclerView(requireActivity().applicationContext, 8)
                }
                1 -> {
                    setRecyclerView(requireContext().applicationContext, 1)
                }

                else -> {}
            }
        }

    }

    private fun showSelectedItem(trabajito: TrabajitoModel){
        historyViewModel.setSelected(trabajito)

        val direction = HistoryFragmentDirections.actionNavigationHistoryToTrabajitoFragment(trabajito)
        findNavController().navigate(direction)
    }

    private fun displayTrrabajito(page: Int){
        if (page == 1){
            adapter.setData(historyViewModel.getCompletedTrabajitos())
            adapter.notifyDataSetChanged()
        }else{
            adapter.setData(historyViewModel.getTrabajitos())
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