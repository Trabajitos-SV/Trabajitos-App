package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MunicipalityModel (
    val id: String,
    val name: String
):Parcelable
