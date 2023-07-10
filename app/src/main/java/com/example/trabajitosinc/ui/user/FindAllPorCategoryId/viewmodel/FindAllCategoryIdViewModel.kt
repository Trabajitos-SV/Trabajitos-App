package com.example.trabajitosinc.ui.user.FindAllPorCategoryId.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.PortfolioCRepository
import com.example.trabajitosinc.ui.user.FindAllPorCategoryId.FindAllCategoryIdUiStates
import kotlinx.coroutines.launch

class FindAllCategoryIdViewModel(private val repository: PortfolioCRepository): ViewModel() {

    val idCategory = MutableLiveData("")


    private val _status = MutableLiveData<FindAllCategoryIdUiStates> (FindAllCategoryIdUiStates.Resume)

    val status: LiveData<FindAllCategoryIdUiStates>
        get() = _status


}