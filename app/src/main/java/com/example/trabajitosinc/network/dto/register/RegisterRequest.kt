package com.example.trabajitosinc.network.dto.register

data class RegisterRequest(
    val name: String,
    val email: String,
    val phone : String,
    val password: String
)
