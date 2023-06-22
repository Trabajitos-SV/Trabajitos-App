package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.data.models.UserComplexModel

class UserComplexRepository(private val complexUsers: MutableList<UserComplexModel>) {

    fun getComplexUsers() = complexUsers

}