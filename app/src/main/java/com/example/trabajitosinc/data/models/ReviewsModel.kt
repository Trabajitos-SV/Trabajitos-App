package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReviewsModel(
    val description: String,
    val qualification: Int,
    val id_user: String
):Parcelable

