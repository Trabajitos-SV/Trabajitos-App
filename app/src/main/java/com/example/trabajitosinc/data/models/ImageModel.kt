package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageModel(
    val secureUrl: String,
    val publicId: String,
    val _id: String
):Parcelable