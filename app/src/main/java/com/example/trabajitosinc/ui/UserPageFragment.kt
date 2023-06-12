package com.example.trabajitosinc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentUserPageBinding

class UserPageFragment : Fragment() {

    private lateinit var binding : FragmentUserPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editPersonalDataButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_user_to_editProfileFragment)
        }

        binding.myPortfolioButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_user_to_createPortfolioFragment)
        }

        binding.imageProfile.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_user_to_userInfoFragment)
        }
    }

}