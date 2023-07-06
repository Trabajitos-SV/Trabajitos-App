package com.example.trabajitosinc.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.CredentialsRepository
import com.example.trabajitosinc.ui.register.RegisterUiStatus
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository : CredentialsRepository ) : ViewModel(){
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var phone = MutableLiveData("")

    private val _status = MutableLiveData<RegisterUiStatus>(RegisterUiStatus.Resume)
    val status: LiveData<RegisterUiStatus>
        get() = _status

    private fun register(name: String, phone: String, email: String,  password: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.register(name, phone, email, password)){
                    is ApiResponse.Error -> RegisterUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> RegisterUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> RegisterUiStatus.Success
                }
            )
        }
    }

    fun onRegister() {
        if(!validateData()){
            _status.value = RegisterUiStatus.ErrorWithMessage("Wrong information")
            return
        }
        register(name.value!!, phone.value!!, email.value!!, password.value!!)
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            email.value.isNullOrEmpty() -> return false
            password.value.isNullOrEmpty() -> return false
            phone.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearStatus() {
        _status.value = RegisterUiStatus.Resume
    }

    fun clearData() {
        name.value = ""
        email.value = ""
        password.value = ""
        phone.value = ""
    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                RegisterViewModel(app.credentialsRepository)
            }
        }
    }

}