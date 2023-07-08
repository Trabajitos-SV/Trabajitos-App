package com.example.trabajitosinc.ui.category.selectedworker.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.repositories.PortfolioRepository

class SelectedWorkerViewModel (
    private val portfolioRepository: PortfolioRepository): ViewModel(){

    private val selectedImage = MutableLiveData<Uri?>()

    val title = MutableLiveData("")
    val description = MutableLiveData("")
    val images = MutableLiveData("")
    val user = MutableLiveData("")
    val category = MutableLiveData("")
    val review = MutableLiveData("")


    fun clearPortfolioData() {
        title.value = ""
        description.value = ""
        images.value = ""
        user.value = ""
        category.value = ""
        review.value = ""
    }

    fun setSelectedPortfolio(portfolio: PortfolioModel){
        clearPortfolioData()
        title.value = portfolio.title
        description.value = portfolio.description
        images.value = portfolio.images.toString()
        user.value = portfolio.user.toString()
        category.value = portfolio.category.toString()
        review.value = portfolio.review.toString()
    }

    fun getSelectedImage(): Uri? {
        return selectedImage.value
    }

    fun setSelectedImage(imageUri: Uri?) {
        selectedImage.value = imageUri
        println("Selected Image: $imageUri")

    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                SelectedWorkerViewModel(app.portfolioRepository)
            }
        }
    }


}

