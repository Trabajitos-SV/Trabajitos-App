package com.example.trabajitosinc.ui.history.trabajito.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.repositories.TrabajitosRepository
import com.example.trabajitosinc.ui.history.historymain.viewmodel.HistoryViewModel
import java.util.Date

class SelectedTrabajitoViewModel(private val repository: TrabajitosRepository)
    : ViewModel(){

    suspend fun startTrabajito(id: String, dateFinish: Date, status: String) = repository.startTrabajito(id, dateFinish, status)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TrabajitosApplication
                SelectedTrabajitoViewModel(app.trabajitosRepository)
            }
        }
    }
}