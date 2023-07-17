package com.example.trabajitosinc.ui.history.historymain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.trabajitosinc.databinding.FragmentHistoryBinding
import com.example.trabajitosinc.ui.history.historymain.viewpager.HistoryRecyclerViewContainer
import com.example.trabajitosinc.ui.history.historymain.viewmodel.HistoryViewModel
import com.google.android.material.tabs.TabLayoutMediator

class HistoryFragment : Fragment() {

    private lateinit var demoCollectionAdapter: DemoCollectioAdapter

    //private lateinit var viewPager: ViewPager2

    class DemoCollectioAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            val fragment = HistoryRecyclerViewContainer()

            fragment.arguments = Bundle().apply {
                putInt(ARG_OBJECT, position)
            }

            return fragment
        }
    }

    companion object{
        private const val ARG_OBJECT = "object"
    }

    private lateinit var binding: FragmentHistoryBinding

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


        bind()

        TabLayoutMediator(binding.historyTabs, binding.historyPager){ tab, position ->
            when (position){
                0 -> {
                    tab.text = "My works"
                }
                1 -> {
                    tab.text="My requests"
                }
            }
        }.attach()

    }

    private fun bind() {
        demoCollectionAdapter = DemoCollectioAdapter(this)
        binding.historyPager.adapter = demoCollectionAdapter
    }

}