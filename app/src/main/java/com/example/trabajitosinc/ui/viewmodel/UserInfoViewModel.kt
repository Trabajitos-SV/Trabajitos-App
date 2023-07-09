package com.example.trabajitosinc.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.repositories.UserRepository

class UserInfoViewModel(private val repository : UserRepository) : ViewModel(){
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var phone = MutableLiveData("")
    var municipality = MutableLiveData("")
    var image = MutableLiveData("")

    fun getUsers() = repository.getUsers()


    fun clearUserData(){
        name.value = ""
        email.value = ""
        phone.value = ""
        municipality.value = ""
        image.value = ""
    }

    fun setSelectedUser(user : UserModel){
        clearUserData()
        name.value = user.name
        email.value = user.email
        phone.value = user.phone.toString()
        municipality.value = user.municipality.name
        image.value = user.image.toString()

    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TrabajitosApplication
                UserInfoViewModel(app.userRepository)
            }
        }
    }


}