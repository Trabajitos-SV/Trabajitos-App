package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
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
):Parcelable