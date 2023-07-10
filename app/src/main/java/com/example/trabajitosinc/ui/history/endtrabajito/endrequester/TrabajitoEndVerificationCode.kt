package com.example.trabajitosinc.ui.history.endtrabajito.endrequester

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.trabajitosinc.databinding.FragmentTrabajitoEndVerificationCodeBinding
import com.example.trabajitosinc.ui.history.endtrabajito.endrequester.viewmodel.TrabajitoEndVerificationViewModel

class TrabajitoEndVerificationCode : Fragment() {

    private val trabajitoEndVerificationViewModel: TrabajitoEndVerificationViewModel by activityViewModels {
        TrabajitoEndVerificationViewModel.factory
    }
    private lateinit var binding: FragmentTrabajitoEndVerificationCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrabajitoEndVerificationCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numeroSeguridad = trabajitoEndVerificationViewModel.getVerificationCode().toString()
        val numeroSeparado = numeroSeguridad.chunked(1).joinToString("     ")

        binding.confirmationNumberText.text = numeroSeparado
    }

}