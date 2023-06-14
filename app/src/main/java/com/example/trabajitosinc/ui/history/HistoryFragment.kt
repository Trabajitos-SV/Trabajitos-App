package com.example.trabajitosinc.ui.history

import android.os.Bundle
import android.text.Spannable.Factory
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.databinding.FragmentHistoryBinding
import com.example.trabajitosinc.ui.history.recyclerview.TrabajitoRecyclerViewAdapter
import com.example.trabajitosinc.ui.viewmodel.HistoryViewModel

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private lateinit var adapter: TrabajitoRecyclerViewAdapter

    private val historyViewmodel: HistoryViewModel by activityViewModels {
        HistoryViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)
    }

    private fun showSelectedItem(trabajito: TrabajitoModel){
        historyViewmodel.setSelected(trabajito)
        Log.d("APP_TAG", trabajito.workerName)
        findNavController().navigate(R.id.action_navigation_history_to_trabajitoFragment)
    }

    private fun displayTrrabajito(){
        adapter.setData(historyViewmodel.getTrabajitos())
        adapter.notifyDataSetChanged()
    }

    fun setRecyclerView(view: View){
        binding.myTrabajitosList.layoutManager = LinearLayoutManager(view.context)

        adapter = TrabajitoRecyclerViewAdapter {
            showSelectedItem(it)
        }

        binding.myTrabajitosList.adapter =adapter
        displayTrrabajito()
    }

}