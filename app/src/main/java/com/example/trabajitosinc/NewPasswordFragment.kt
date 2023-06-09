package com.example.trabajitosinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabajitosinc.databinding.FragmentNewPasswordBinding


class NewPasswordFragment : Fragment() {


    private lateinit var binding : FragmentNewPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

}