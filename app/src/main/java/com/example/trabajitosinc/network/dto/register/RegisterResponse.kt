package com.example.trabajitosinc.network.dto.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("msg") val message : String
)
