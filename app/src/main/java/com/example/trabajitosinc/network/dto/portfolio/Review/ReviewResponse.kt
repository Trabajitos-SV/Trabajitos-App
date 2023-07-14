package com.example.trabajitosinc.network.dto.portfolio.Review

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReviewResponse (
    val description: String,
    val qualification: Int,
    val id_user: String
    ):Parcelable