package com.example.trabajitosinc.ui.user.FindAllPorCategoryId.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.PortfolioCRepository
import com.example.trabajitosinc.ui.user.FindAllPorCategoryId.FindAllCategoryIdUiStates
import com.example.trabajitosinc.ui.user.portfolio.viewmodel.CreatePortfollioViewModel
import kotlinx.coroutines.launch

class FindAllCategoryIdViewModel(private val repository: PortfolioCRepository) : ViewModel() {

    val idCategory = MutableLiveData("")


    private val _status =
        MutableLiveData<FindAllCategoryIdUiStates>(FindAllCategoryIdUiStates.Resume)

    val status: LiveData<FindAllCategoryIdUiStates>
        get() = _status


    private fun findAllCategoryById(idCategory: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.fndPortfolioByCategoryId(idCategory)) {
                    is ApiResponse.Error -> FindAllCategoryIdUiStates.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> FindAllCategoryIdUiStates.ErrorWithMessage(
                        response.message
                    )

                    is ApiResponse.Success -> FindAllCategoryIdUiStates.Success
                }
            )
        }
    }

    fun clearStates() {
        _status.value = FindAllCategoryIdUiStates.Resume
    }

    fun clearData() {
        idCategory.value = ""
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