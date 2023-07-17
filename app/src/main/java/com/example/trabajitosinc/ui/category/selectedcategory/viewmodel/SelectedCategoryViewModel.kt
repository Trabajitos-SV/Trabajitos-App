package com.example.trabajitosinc.ui.category.selectedcategory.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.ImageModel
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst
import com.example.trabajitosinc.repositories.PortfolioRepository
import com.example.trabajitosinc.repository.PortfolioCRepository

class SelectedCategoryViewModel(
    private val repository: PortfolioRepository,
    private val remoteCRepository: PortfolioCRepository
) : ViewModel() {
    var userId = MutableLiveData("")
    var portfolioId = MutableLiveData("")
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var phone = MutableLiveData("")
    var municipality = MutableLiveData("")
    var userImage = MutableLiveData("")
    val images = MutableLiveData<List<ImageModel>>()
    val title = MutableLiveData("")
    val category = MutableLiveData("")
    val description = MutableLiveData("")

    fun setSelected(portfolio: FindPortfolioByCategoryIdLitst) {
        clearData()
        userId.value = portfolio.user._id
        portfolioId.value = portfolio._id
        name.value = portfolio.user.name
        email.value = portfolio.user.email
        phone.value = portfolio.user.phone.toString()
        municipality.value = portfolio.user.municipality
        //userImage.value = portfolio.user.image
        title.value = portfolio.title
        category.value = portfolio.category.name
        description.value = portfolio.description
        images.value = portfolio.uploadedImages
    }

    private fun clearData() {
        userId.value = ""
        name.value = ""
        email.value = ""
        phone.value = ""
        municipality.value = ""
        userImage.value = ""
        title.value = ""
        category.value = ""
        description.value = ""
        images.value = emptyList()
    }

    fun getPortfolios() = repository.getPortfolios()

    fun getPortfolioByCategory(selctedCategory: String) =
        repository.getSelectedCategory(selctedCategory)

    suspend fun getPortfolioByCatergoryRemote(selectCategory: String, page: Int) =
        remoteCRepository.fndPortfolioByCategoryId(selectCategory, page)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                SelectedCategoryViewModel(app.portfolioRepository, app.portfolioCRepository)
            }
        }
    }

}