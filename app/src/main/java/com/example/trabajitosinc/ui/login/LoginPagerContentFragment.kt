package com.example.trabajitosinc.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.trabajitosinc.R
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.databinding.FragmentLoginPagerContentBinding
import com.example.trabajitosinc.ui.LoginActivity
import com.example.trabajitosinc.ui.MainActivity
import com.example.trabajitosinc.ui.login.viewmodel.LoginViewModel
import com.example.trabajitosinc.util.PreferenceHelper
import com.example.trabajitosinc.util.PreferenceHelper.set


class LoginPagerContentFragment : Fragment() {

    private lateinit var binding: FragmentLoginPagerContentBinding

    private val  loginViewModel : LoginViewModel by activityViewModels {
        LoginViewModel.Factory
    }


    val app by lazy {
        requireActivity().application as TrabajitosApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginPagerContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.textForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
        }

        setViewModel()

        observeStatus()

    }

    private fun goToHome() {
        val i = Intent(context, MainActivity::class.java)
        creteSessionPreferences()
        startActivity(i)
        requireActivity().finish()
    }
    private fun creteSessionPreferences() {
        val preferences = PreferenceHelper.defaultPrefs(requireContext())
        preferences["session"] = true
    }


    private fun setViewModel() {
        binding.viewmodel = loginViewModel
    }

    private fun observeStatus() {
        loginViewModel.status.observe(viewLifecycleOwner) { status ->
            handleUiStatus(status)
        }
    }

    private fun handleUiStatus(status: LoginUiStatus) {
        when(status) {
            is LoginUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }
            is LoginUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is LoginUiStatus.Success -> {
                loginViewModel.clearStatus()
                loginViewModel.clearData()
                app.saveAuthToken(status.token)
                //findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                goToHome()
            }

            else -> {}
        }
    }


}