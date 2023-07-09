package com.example.trabajitosinc.ui.user.portfolio.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.PortfolioCRepository
import com.example.trabajitosinc.ui.user.portfolio.CreatePortfolioUiStates
import kotlinx.coroutines.launch

class CreatePortfollioViewModel(private val repository: PortfolioCRepository): ViewModel(){
    var title = MutableLiveData("")
    var description = MutableLiveData("")
    var images = MutableLiveData("")
    var category = MutableLiveData("")

    private val _status = MutableLiveData<CreatePortfolioUiStates>(CreatePortfolioUiStates.Resume)

    val status: LiveData<CreatePortfolioUiStates>
        get() = _status


    private fun createPortfolio(title: String, description: String, images: Array<String>, category: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.createPortfolio(title, description, images, category)){
                    is ApiResponse.Error -> CreatePortfolioUiStates.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> CreatePortfolioUiStates.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> CreatePortfolioUiStates.Success
                }
            )
        }
    }


    fun onCreatePortfolio() {
        if(!validateData()){
            _status.value = CreatePortfolioUiStates.ErrorWithMessage("Wrong information")
            return
        }
    }

    private fun validateData(): Boolean {
        when {
            title.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            images.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearStates() {
        _status.value = CreatePortfolioUiStates.Resume
    }

    fun clearData() {
        title.value = ""
        description.value = ""
        images.value = ""
        category.value = ""
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                CreatePortfollioViewModel(app.portfolioCRepository)
            }
        }
    }


}