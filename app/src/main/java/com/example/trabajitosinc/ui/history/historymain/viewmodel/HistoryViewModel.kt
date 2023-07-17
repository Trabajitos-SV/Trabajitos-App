package com.example.trabajitosinc.ui.history.historymain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.TrabajitoModel
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.FindTrabajitosRequestsResponse
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel
import com.example.trabajitosinc.repositories.HistoryRepository
import com.example.trabajitosinc.repositories.TrabajitosRepository

class HistoryViewModel(private val repository: HistoryRepository,
                       private val repository2: TrabajitosRepository
): ViewModel() {
    val trabajitos = MutableLiveData<ApiResponse<FindTrabajitosRequestsResponse>>()

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

    fun setSelected(trabajito: tempRequestModel){
        clearData()

        workerId.value = trabajito.id_hired._id
        requesterId.value = trabajito.id_solicitor
        workerName.value = trabajito.id_hired.name
        workerLocation.value = ""
        phone.value = trabajito.id_hired.phone
        startDate.value = trabajito.dateInit
        endDate.value = trabajito.dateInit
        taskDescription.value = trabajito.description
        bill.value = "Pending"
        TrabajitoStatus.value = trabajito.status.name

    }

    suspend fun getMyRequests() = repository2.getMyRequests()

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TrabajitosApplication
                HistoryViewModel(app.historyRepository, app.trabajitosRepository)
            }
        }
    }

}