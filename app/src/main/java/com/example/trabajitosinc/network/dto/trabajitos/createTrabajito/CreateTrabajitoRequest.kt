package com.example.trabajitosinc.network.dto.trabajitos.createTrabajito

data class CreateTrabajitoRequest(
    val description: String,
    val dateInit: String,
    val status: String,
    val id_hired: String
)
