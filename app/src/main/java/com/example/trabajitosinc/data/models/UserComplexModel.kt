package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserComplexModel(
    val id : String,
    val name: String,
    val email: String,
    val number: Int,
    val location: String,
    val image: Int,
    val portfolio: PortfolioModel2
): Parcelable
