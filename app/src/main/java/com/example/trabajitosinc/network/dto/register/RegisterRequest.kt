package com.example.trabajitosinc.network.dto.register

data class RegisterRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String
)
