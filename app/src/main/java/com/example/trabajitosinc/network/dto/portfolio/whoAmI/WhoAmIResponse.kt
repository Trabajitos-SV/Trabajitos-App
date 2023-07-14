package com.example.trabajitosinc.network.dto.portfolio.whoAmI

import com.example.trabajitosinc.data.models.MunicipalityModel

data class WhoAmIResponse(
    val _id: String,
    val name: String,
    val phone: String,
    val email: String,
    val municipality: String,
)