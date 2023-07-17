package com.example.trabajitosinc.network.dto.trabajitos.createTrabajito

import com.example.trabajitosinc.data.models.BillModel
import com.google.gson.annotations.SerializedName

data class CreateTrabajitoResponse(
    val description: String,
    val dateInit: String,
    val endNumber: String,
    val id_solicitor: String,
    val hidden: Boolean,
    val id_hired: String,
    val status: String,
    val _id: String,
    val bill: List<BillModel>,
    @SerializedName("__v") val version: Int
)
