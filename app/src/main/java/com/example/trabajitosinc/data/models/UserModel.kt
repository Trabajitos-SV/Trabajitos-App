package com.example.trabajitosinc.data.models

class UserModel(
    val id : String,
    val name: String,
    val email: String,
    val phone: Int,
    val municipality: MunicipalityModel,
    val image: String
    )