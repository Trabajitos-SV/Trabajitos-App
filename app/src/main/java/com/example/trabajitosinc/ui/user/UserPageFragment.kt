package com.example.trabajitosinc.ui.user

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentUserPageBinding
import com.example.trabajitosinc.ui.LoginActivity
import com.example.trabajitosinc.util.PreferenceHelper
import com.example.trabajitosinc.util.PreferenceHelper.set

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

        binding.logoutButton.setOnClickListener {
            //findNavController().navigate(R.id.action_navigation_user_to_loginActivity)
            clearSessioPrefferences(view)
            goToLogin()
        }
    }
    private fun goToLogin(){
        val i = Intent(context, LoginActivity::class.java)
        startActivity(i)
        requireActivity().finish()
    }

    private fun clearSessioPrefferences(view: View) {
        //val preferences = PreferenceHelper.defaultPrefs(requireContext())
        //preferences["session"] = false
    }

}