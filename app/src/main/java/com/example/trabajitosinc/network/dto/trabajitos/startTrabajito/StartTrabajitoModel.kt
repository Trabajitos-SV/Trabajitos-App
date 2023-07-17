package com.example.trabajitosinc.network.dto.trabajitos.startTrabajito

import com.example.trabajitosinc.data.models.BillModel
import com.example.trabajitosinc.data.models.Solicitor_HiredModel
import com.example.trabajitosinc.data.models.StatusModel
import com.google.gson.annotations.SerializedName

data class StartTrabajitoModel(
    val _id: String,
    val description: String,
    val dateInit: String,
    val endNumber: String,
    val id_solicitor: String,
    val hidden: Boolean,
    val id_hired: String,
    val status: String,
    val bill: List<BillModel>,
    @SerializedName("__v") val version: Int,
    val dateFinish: String?
)
