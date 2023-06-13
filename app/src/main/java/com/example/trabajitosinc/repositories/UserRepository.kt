package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.data.models.UserModel

class UserRepository (private val users : MutableList<UserModel>) {

    fun getUsers() = users
}