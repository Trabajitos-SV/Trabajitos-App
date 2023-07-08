package com.example.trabajitosinc.ui.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.CredentialsRepository
import com.example.trabajitosinc.ui.login.LoginUiStatus
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: CredentialsRepository) : ViewModel() {

    var email = MutableLiveData("")
    var password = MutableLiveData("")

    private val _status = MutableLiveData<LoginUiStatus>(LoginUiStatus.Resume)
    val status: MutableLiveData<LoginUiStatus>
        get() = _status

    private fun login(email: String, password: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.login(email, password)){
                    is ApiResponse.Error -> LoginUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> LoginUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> LoginUiStatus.Success(response.data)
                }
            )
        }

    }

    fun onLogin() {
        if(!validateData()){
            _status.value = LoginUiStatus.ErrorWithMessage("Wrong information")
            return
        }

        login(email.value!!, password.value!!)

    }

    private fun validateData(): Boolean {
        when {
            email.value.isNullOrEmpty() -> return false
            password.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        email.value = ""
        password.value = ""
    }

    fun clearStatus() {
        _status.value = LoginUiStatus.Resume
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                LoginViewModel(app.credentialsRepository)
            }
        }
    }
}