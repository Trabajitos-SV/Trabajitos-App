package com.example.trabajitosinc.data.models

data class PortfolioModel (
    val title: String,
    val description: String,
    val images: String,
    val user: List<UserModel>,
    val category: List<CategoryModel>,
    val review: Review
)
data class Review(
    val description: String,
    val qualification: Int,
    val id_user: List<UserModel>,
)