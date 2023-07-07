package com.example.trabajitosinc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentTrabajitoEndVerificationCodeBinding
import com.example.trabajitosinc.ui.viewmodel.TrabajitoEndVerificationViewModel

class TrabajitoEndVerificationCode : Fragment() {

    private val trabajitoEndVerificationViewModel: TrabajitoEndVerificationViewModel by activityViewModels {
        TrabajitoEndVerificationViewModel.factory
    }
    private lateinit var binding: FragmentTrabajitoEndVerificationCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trabajito_end_verification_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numeroSeguridad = trabajitoEndVerificationViewModel.getVerificationCode().toString()
        val numeroSeparado = numeroSeguridad.chunked(1).joinToString("     ")

    }

}