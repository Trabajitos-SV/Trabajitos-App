package com.example.trabajitosinc.ui.user.CreatePortfolio

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.repositories.PortfolioRepository

class CreatePortfolioViewModel(
    private val portfolioRepository : PortfolioRepository ): ViewModel() {

    private var selectedImage: Uri? = null

    //Datos del Portafolio

    val title = MutableLiveData("")
    val description = MutableLiveData("")
    val images = MutableLiveData("")
    val user = MutableLiveData("")
    val category = MutableLiveData("")
    val review = MutableLiveData("")

    fun getPortfolio()= portfolioRepository.getPortfolios()

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
        selectedImage = null

    }

    fun getSelectedImage(): Uri? {
        return selectedImage
    }

    fun setSelectedImage(imageUri: Uri?) {
        selectedImage = imageUri
    }



    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                CreatePortfolioViewModel(app.portfolioRepository)
            }
        }
    }

}

