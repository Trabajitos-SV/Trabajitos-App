package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PortfolioModel2(
    val images: Array<String>,
    val title: String,
    val category: String,
    val description: String
): Parcelable
