package com.example.trabajitosinc.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.trabajitosinc.databinding.FragmentLoginBinding
import com.example.trabajitosinc.ui.register.RegisterPagerContentFragment
import com.google.android.material.tabs.TabLayoutMediator


class LoginFragment : Fragment() {

    private lateinit var demoCollectionAdapter: DemoCollectionAdapter

    class DemoCollectionAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> LoginPagerContentFragment()
                1 -> RegisterPagerContentFragment()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }
    }

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()

        TabLayoutMediator(binding.loginTabLayout, binding.loginPager) { tab, position ->
            when (position) {
                0 -> tab.text = "          Login           "
                1 -> tab.text = "Register"
            }
        }.attach()
    }

    private fun bind() {
        demoCollectionAdapter = DemoCollectionAdapter(this)
        binding.loginPager.adapter = demoCollectionAdapter
    }
}
