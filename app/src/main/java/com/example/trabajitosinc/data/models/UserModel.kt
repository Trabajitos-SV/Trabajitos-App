package com.example.trabajitosinc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserModel(
    val id : String,
    val name: String,
    val email: String,
    val phone: Int,
    val municipality: String,
    val image: String
):Parcelable