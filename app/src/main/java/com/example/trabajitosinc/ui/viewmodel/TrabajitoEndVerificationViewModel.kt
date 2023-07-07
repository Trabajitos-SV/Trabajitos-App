package com.example.trabajitosinc.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import kotlin.random.Random

class TrabajitoEndVerificationViewModel():ViewModel() {

    fun getVerificationCode(): Int{
        val random = Random(System.currentTimeMillis())
        return random.nextInt(1000, 10000)
    }

    companion object {
        val factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                TrabajitoEndVerificationViewModel()
            }
        }
    }
}