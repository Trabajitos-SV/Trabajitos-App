package com.example.trabajitosinc.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.repositories.CategoryRepository
import com.example.trabajitosinc.repositories.UserRepository

class HomeViewModel(
    private val userRepository: UserRepository,
    private val categoryRepository: CategoryRepository) : ViewModel() {

    // Datos de usuario
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var phone = MutableLiveData("")
    var municipality = MutableLiveData("")
    var image = MutableLiveData("")


    // Datos de categoría
    var categoryName = MutableLiveData("")
    var categoryImage  = MutableLiveData("")

    // Transformación del dato de imagen de categoría a entero
    val categoryImageInt = Transformations.map(categoryImage) {
        try {
            it.toInt()
        } catch (e: NumberFormatException) {
            0
        }
    }

    // Obtener usuarios desde el repositorio
    fun getUsers() = userRepository.getUsers()

    // Obtener categorías desde el repositorio
    fun getCategories() = categoryRepository.getCategories()

    // Limpiar los datos de usuario
    fun clearUserData() {
        name.value = ""
        email.value = ""
        phone.value = ""
        municipality.value = ""
        image.value = ""
    }

    // Limpiar los datos de categoría
    fun clearCategoryData() {
        categoryName.value = ""
        categoryImage.value = ""
    }

    // Establecer el usuario seleccionado
    fun setSelectedUser(user: UserModel) {
        clearUserData()
        name.value = user.name
        email.value = user.email
        phone.value = user.phone.toString()
        municipality.value = user.municipality.name
        image.value = user.image.toString()
    }

    // Establecer la categoría seleccionada
    fun setSelectedCategory(category: CategoryModel) {
        clearCategoryData()
        categoryName.value = category.name
        categoryImage.value = category.image.toString()
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                HomeViewModel(app.userRepository, app.categoryRepository)
            }
        }
    }
}

