package com.example.trabajitosinc.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.UserComplexModel
import com.example.trabajitosinc.repositories.UserComplexRepository

class SelectedCategoryViewModel(private val repository: UserComplexRepository): ViewModel() {
    var id = MutableLiveData("")
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var number = MutableLiveData("")
    var location = MutableLiveData("")
    var image = MutableLiveData("")
    //val images = MutableLiveData("")
    val title = MutableLiveData("")
    val category = MutableLiveData("")
    val description = MutableLiveData("")

    fun setSelected(user: UserComplexModel){
        clearData()
        id.value = user.id
        name.value= user.name
        email.value = user.email
        number.value = user.number.toString()
        location.value = user.location
        image.value = user.image.toString()
        title.value = user.portfolio.title
        category.value = user.portfolio.category
        description.value = user.portfolio.description
    }

    private fun clearData() {
        id.value = ""
        name.value = ""
        email.value = ""
        number.value = ""
        location.value = ""
        image.value = ""
        title.value = ""
        category.value = ""
        description.value = ""
    }

    fun getComplexUsers() = repository.getComplexUsers()

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                SelectedCategoryViewModel(app.userComplexRepository)
            }
        }
    }

}