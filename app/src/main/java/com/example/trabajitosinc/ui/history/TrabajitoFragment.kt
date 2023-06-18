package com.example.trabajitosinc.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentTrabajitoBinding

class TrabajitoFragment : Fragment() {

    private lateinit var binding: FragmentTrabajitoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrabajitoBinding.inflate(inflater, container, false)
        return binding.root
    }

}