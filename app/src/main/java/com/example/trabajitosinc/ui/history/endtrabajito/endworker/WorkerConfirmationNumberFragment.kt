package com.example.trabajitosinc.ui.history.endtrabajito.endworker

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.trabajitosinc.databinding.FragmentWorkerConfirmationNumberBinding

class WorkerConfirmationNumberFragment : Fragment() {

    private lateinit var binding: FragmentWorkerConfirmationNumberBinding

    companion object{
        private const val TEST_VERIFY_CODE = "6786"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkerConfirmationNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()

        initFocus()
    }

    private fun setListener() {
        binding.root.setOnClickListener{
            val inputManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
        }

        setTextChangedListener(fromEditText = binding.editTextOneEndConfirmation, targetEditText = binding.editText2EndConfirmation)
        setTextChangedListener(fromEditText = binding.editText2EndConfirmation, targetEditText = binding.editText3EndConfirmation)
        setTextChangedListener(fromEditText = binding.editText3EndConfirmation, targetEditText = binding.editText4EndConfirmation)
        setTextChangedListener(fromEditText = binding.editText4EndConfirmation, done = {

            verifyOTPCode()
        })

        setKeyListener(fromEditText = binding.editText2EndConfirmation, backToEditText = binding.editTextOneEndConfirmation)
        setKeyListener(fromEditText = binding.editText3EndConfirmation, backToEditText = binding.editText2EndConfirmation)
        setKeyListener(fromEditText = binding.editText4EndConfirmation, backToEditText = binding.editText4EndConfirmation)
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
                    targetEditText?.let {editText ->

                        editText.isEnabled = true
                        editText.requestFocus()

                    } ?: kotlin.run {
                        done?.let {done ->
                            done()
                        }
                    }

                    fromEditText.clearFocus()
                    fromEditText.isEnabled = false
                }
            }
        }
    }

    private fun setKeyListener(fromEditText: EditText, backToEditText: EditText){
        fromEditText.setOnKeyListener(){ _, _, event ->
            //val event = it as KeyEvent

            if (null != event && KeyEvent.KEYCODE_DEL == event.keyCode){
                backToEditText.isEnabled = true
                backToEditText.requestFocus()
                backToEditText.setText("")

                fromEditText.clearFocus()
                fromEditText.isEnabled = false
            }

            false
        }
    }

    private fun verifyOTPCode() {
        val optCode = binding.editTextOneEndConfirmation.text.toString().trim() +
                binding.editText2EndConfirmation.text.toString().trim() +
                binding.editText3EndConfirmation.text.toString().trim() +
                binding.editText4EndConfirmation.text.toString().trim()

        if (4 != optCode.length){
            return
        }

        if (optCode == TEST_VERIFY_CODE){

            Toast.makeText(this.context, "success" , Toast.LENGTH_LONG)

            val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)

            return
        }

        Toast.makeText(this.context, "error, input again", Toast.LENGTH_LONG).show()
        reset()
    }

}