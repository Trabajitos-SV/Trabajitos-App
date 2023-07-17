package com.example.trabajitosinc.ui.history.historymain.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.databinding.FragmentHistoryRecyclerViewBinding
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.trabajitos.findJobs.tempJobModel
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel
import com.example.trabajitosinc.ui.history.historymain.HistoryFragmentDirections
import com.example.trabajitosinc.ui.history.historymain.viewmodel.HistoryViewModel
import com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview.JobRecyclerViewAdapter
import com.example.trabajitosinc.ui.history.historymain.viewpager.recyclerview.TrabajitoRecyclerViewAdapter
import kotlinx.coroutines.launch

class HistoryRecyclerViewContainer : Fragment() {

    private lateinit var binding: FragmentHistoryRecyclerViewBinding
    private lateinit var adapter: TrabajitoRecyclerViewAdapter
    private lateinit var jobAdapter: JobRecyclerViewAdapter

    private val viewModel: HistoryViewModel by activityViewModels {
        HistoryViewModel.Factory
    }

    private var trabajitos : MutableList<tempRequestModel> = mutableListOf()
    private var myJobs : MutableList<tempJobModel> = mutableListOf()


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

                        when(val response = viewModel.getMyWorks()){
                            is ApiResponse.Error -> Toast.makeText(context, "There was a problem", Toast.LENGTH_SHORT)
                                .show()
                            is ApiResponse.ErrorWithMessage -> Toast.makeText(context, "There was a problem", Toast.LENGTH_SHORT).show()
                            is ApiResponse.Success -> {
                                myJobs.clear()
                                myJobs.addAll(response.data.docs)
                                setRecyclerViewJobs(requireContext(), 0)

                            }
                        }
                    }
                    setRecyclerView(requireActivity().applicationContext, 8)
                }
                1 -> {
                    lifecycleScope.launch{

                        when(val response = viewModel.getMyRequests()){
                            is ApiResponse.Error -> Toast.makeText(context, "There was a problem", Toast.LENGTH_SHORT).show()
                            is ApiResponse.ErrorWithMessage -> Toast.makeText(context, "There was a problem", Toast.LENGTH_SHORT).show()
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

        val directions = HistoryFragmentDirections.actionNavigationHistoryToTrabajitoFragment(
            trabajito.id_hired.name, trabajito.id_hired.email, trabajito.id_hired.phone, trabajito.dateInit, trabajito.dateFinish?: "Pending", trabajito.description, trabajito.status.name
        )
        findNavController().navigate(directions)
    }

    private fun showSelectedJob(job : tempJobModel){
        historyViewModel.setSelectedJob(job)

        val directions = HistoryFragmentDirections.actionNavigationHistoryToTrabajitoFragment(
            job.id_solicitor.name, job.id_solicitor.email, job.id_solicitor.phone, job.dateInit, job.dateFinish?: "Pending", job.description, job.status.name
        )
        findNavController().navigate(directions)
    }

    private fun displayTrrabajito(page: Int){
        if (page == 0){
            jobAdapter.setData(myJobs)
            jobAdapter.notifyDataSetChanged()
        }else{
            adapter.setData(trabajitos)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setRecyclerView(context: Context, page: Int ){

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

    private fun setRecyclerViewJobs(context: Context, page: Int){
        binding.myTrabajitosList.layoutManager = LinearLayoutManager(context)

        jobAdapter = JobRecyclerViewAdapter (context){
            showSelectedJob(it)
        }

        binding.myTrabajitosList.adapter = jobAdapter
        displayTrrabajito(page)
    }

}