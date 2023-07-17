package com.example.trabajitosinc.network.dto.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("identifier") val email : String,
    val password : String
)
