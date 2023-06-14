package com.example.trabajitosinc.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trabajitosinc.TrabajitosApplication
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.repositories.UserRepository

class UserInfoViewModel(private val repository : UserRepository) : ViewModel(){
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var number = MutableLiveData("")
    var location = MutableLiveData("")
    var image = MutableLiveData("")

    fun getUsers() = repository.getUsers()

    fun clearData(){
        name.value = ""
        email.value = ""
        number.value = ""
        location.value = ""
        image.value = ""
    }

    fun setSelectedUser(user : UserModel){
        clearData()
        name.value = user.name
        email.value = user.email
        number.value = user.number.toString()
        location.value = user.location
        image.value = user.image.toString()

    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TrabajitosApplication
                UserInfoViewModel(app.userRepository)
            }
        }
    }


}