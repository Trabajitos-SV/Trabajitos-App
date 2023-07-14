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
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.repository.PortfolioCRepository
import com.example.trabajitosinc.ui.user.portfolio.CreatePortfolioUiStates
import kotlinx.coroutines.launch

class CreatePortfolioViewModel(
    private val portfolioRepository : PortfolioCRepository ): ViewModel() {

    private val selectedImage = MutableLiveData<Uri?>()

    private val portfolio = MutableLiveData<PortfolioModel>()


    var title = MutableLiveData("")
    var description = MutableLiveData("")
    var images = MutableLiveData<Array<String>>()
    var category = MutableLiveData("")


    private val _status = MutableLiveData<CreatePortfolioUiStates>(CreatePortfolioUiStates.Resume)

    val status: LiveData<CreatePortfolioUiStates>
        get() = _status

    private fun createPortfolio(title: String, description: String, images: Array<String>, category: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = portfolioRepository.createPortfolio(title, description, images, category)){
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
        createPortfolio(title.value!!, description.value!!,images.value!!,category.value!!)
    }

    fun clearStates() {
        _status.value = CreatePortfolioUiStates.Resume
    }

    private fun validateData(): Boolean {
        when {
            title.value.isNullOrEmpty() -> {
                return false
            }
            description.value.isNullOrEmpty() -> {
                return false
            }
            images.value.isNullOrEmpty() -> {
                return false
            }
            category.value.isNullOrEmpty() -> {
                return false
            }
        }
        return true
    }

    fun clearData(){
        title.value = ""
        description.value = ""
        images.value = arrayOf()
        category.value = ""
    }


    fun setPortfolio(portfolio: PortfolioModel) {
        this.portfolio.value = portfolio
    }


    fun getSelectedImage(): Uri? {
        return selectedImage.value
    }

    fun setSelectedImage(imageUri: Uri?) {
        selectedImage.value = imageUri
        println("Selected Image: $imageUri")

    }

    init {
        title.observeForever { value ->
            println("Title: $value")
        }
        description.observeForever { value ->
            println("Description: $value")
        }
        images.observeForever { value ->
            println("Images: ${value?.joinToString()}")
        }
        category.observeForever { value ->
            println("Category: $value")
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                CreatePortfolioViewModel(app.portfolioCRepository)
            }
        }
    }

}

