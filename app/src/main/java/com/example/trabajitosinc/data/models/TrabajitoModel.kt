package com.example.trabajitosinc.data.models

data class TrabajitoModel(
    val workerId: String,
    val requesterId: String,
    val workerName: String,
    val workerCategory: String,
    val workerLocation: String,
    val phone: String,
    val startDate: String,
    val endDate: String,
    val taskDescription: String,
    val bill: String,
    val TrabajitoStatus: String
)