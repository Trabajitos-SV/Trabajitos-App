package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PortfolioModel(
    val id: String,
    val title: String,
    val description: String,
    val images: List<String>,
    val user: UserModel,
    val category: String,
    val review: List<ReviewsModel>
):Parcelable
