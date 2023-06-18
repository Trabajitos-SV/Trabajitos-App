package com.example.trabajitosinc.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.repositories.HistoryRepository

class HistoryViewModel(private val repository: HistoryRepository): ViewModel() {

    val workerId = MutableLiveData("")
    val requesterId = MutableLiveData("")
    val workerName = MutableLiveData("")
    val workerCategory = MutableLiveData("")
    val workerLocation = MutableLiveData("")
    val phone = MutableLiveData("")
    val startDate = MutableLiveData("")
    val endDate = MutableLiveData("")
    val taskDescription = MutableLiveData("")
    val bill = MutableLiveData("")
    val TrabajitoStatus = MutableLiveData("")
    val status = MutableLiveData("")

    fun getTrabajitos() = repository.getTrabajitos()

    fun getCompletedTrabajitos() = repository.getCompletedTrabajitos()

    fun clearData(){
        workerId.value = ""
        requesterId.value = ""
        workerName.value = ""
        workerCategory.value = ""
        workerLocation.value = ""
        phone.value = ""
        startDate.value = ""
        endDate.value = ""
        taskDescription.value = ""
        bill.value = ""
        TrabajitoStatus.value = ""
    }

    fun setSelected(trabajito: TrabajitoModel){
        clearData()

        workerId.value = trabajito.workerId
        requesterId.value = trabajito.requesterId
        workerName.value = trabajito.workerName
        workerName.value = trabajito.workerCategory
        workerLocation.value = trabajito.workerLocation
        phone.value = trabajito.phone
        startDate.value = trabajito.startDate
        endDate.value = trabajito.endDate
        taskDescription.value = trabajito.taskDescription
        bill.value = trabajito.bill
        TrabajitoStatus.value = trabajito.TrabajitoStatus

    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TrabajitosApplication
                HistoryViewModel(app.historyRepository)
            }
        }
    }

}