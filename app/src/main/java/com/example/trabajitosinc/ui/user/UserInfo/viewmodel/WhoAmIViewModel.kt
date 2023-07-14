package com.example.trabajitosinc.ui.user.UserInfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.PortfolioCRepository
import com.example.trabajitosinc.ui.user.UserInfo.WhoAmIUiStates
import kotlinx.coroutines.launch

class WhoAmIViewModel(private val repository: PortfolioCRepository): ViewModel(){
    private var token: String = ""

    var _userId = MutableLiveData("")
    var name = MutableLiveData("")
    var phone = MutableLiveData("")
    var email = MutableLiveData("")
    var municipality = MutableLiveData("")


    private val _status = MutableLiveData<WhoAmIUiStates>(WhoAmIUiStates.Resume)

    val status: LiveData<WhoAmIUiStates>
        get() = _status

    suspend fun getMyInfoUser() = repository.getMyPortfolioWhoAmI()

    fun clearStates() {
        _status.value = WhoAmIUiStates.Resume
    }

    fun clearData() {
        _userId.value = ""
        name.value = ""
        phone.value = ""
        email.value = ""
        municipality.value = ""
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TrabajitosApplication
                WhoAmIViewModel(app.portfolioCRepository)
            }
        }
    }
}