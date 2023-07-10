package com.example.trabajitosinc.ui.category.selectedcategory.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.PortfolioModel
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

    //val images = MutableLiveData("")
    val title = MutableLiveData("")
    val category = MutableLiveData("")
    val description = MutableLiveData("")

    fun setSelected(portfolio: PortfolioModel) {
        clearData()
        userId.value = portfolio.user.id
        portfolioId.value = portfolio.id
        name.value = portfolio.user.name
        email.value = portfolio.user.email
        phone.value = portfolio.user.phone.toString()
        municipality.value = portfolio.user.municipality.name
        userImage.value = portfolio.user.image
        title.value = portfolio.title
        category.value = portfolio.category
        description.value = portfolio.description
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
    }

    fun getPortfolios() = repository.getPortfolios()

    fun getPortfolioByCategory(selctedCategory: String) =
        repository.getSelectedCategory(selctedCategory)

    suspend fun getPortfolioByCatergoryRemote(selectCategory: String) =
        remoteCRepository.fndPortfolioByCategoryId(selectCategory)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                SelectedCategoryViewModel(app.portfolioRepository, app.portfolioCRepository)
            }
        }
    }

}