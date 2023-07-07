package com.example.trabajitosinc.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.repositories.CategoryRepository
import java.lang.NumberFormatException

class CategoryViewModel(private val repository: CategoryRepository): ViewModel() {
    var name = MutableLiveData("")
    var image = MutableLiveData("")

    val intLiveData = Transformations.map(image){
        try {
            it.toInt()
        }catch (e: NumberFormatException){
            0
        }
    }

    fun getCategories() = repository.getCategories()

    fun clearData() {
        name.value = ""
        image.value = ""
    }

    fun setSelected(category: CategoryModel){
        clearData()
        name.value = category.name
        image.value = category.image.toString()
    }


    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                CategoryViewModel(app.categoryRepository)
            }
        }
    }
}