package com.example.trabajitosinc.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.addTextChangedListener
import com.example.trabajitosinc.R
import com.example.trabajitosinc.databinding.FragmentWorkerConfirmationNumberBinding
import kotlinx.coroutines.delay

class WorkerConfirmationNumberFragment : Fragment() {

    private lateinit var binding: FragmentWorkerConfirmationNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkerConfirmationNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun initFocus(){
        binding.editTextOneEndConfirmation.isEnabled = true

        binding.editTextOneEndConfirmation.postDelayed({
            binding.editTextOneEndConfirmation.requestFocus()
            val inputMethodeManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodeManager.showSoftInput(binding.editTextOneEndConfirmation, 0)
        }, 500)
    }

    private fun reset() {
        binding.editTextOneEndConfirmation.isEnabled = false
        binding.editText2EndConfirmation.isEnabled = false
        binding.editText3EndConfirmation.isEnabled = false
        binding.editText4EndConfirmation.isEnabled = false

        binding.editTextOneEndConfirmation.setText("")
        binding.editText2EndConfirmation.setText("")
        binding.editText3EndConfirmation.setText("")
        binding.editText4EndConfirmation.setText("")

        initFocus()
    }

    private fun setTextChangedListener(
        fromEditText: EditText,
        targetEditText: EditText? = null,
        done: (() -> Unit)? = null
    ) {

        fromEditText.addTextChangedListener{
            it?.let {string->
                if (string.isNotEmpty()) {
                    targetEditText?.let {
                        //TODO terminar fun
                    }
                }
            }
        }
    }


}