package com.example.trabajitosinc.data.models

data class ReviewsModel(
    val description: String,
    val qualification: Int,
    val id_user: List<UserModel>
)

