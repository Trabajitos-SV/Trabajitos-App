package com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById

import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.ImageModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewResponse

data class FindPortfolioByCategoryIdLitst (
    val _id: String,
    val title: String,
    val description: String,
    val images: List<ImageModel>,
    val user: UserModel,
    val category: CategoryModel,
    val reviews: List<ReviewResponse> = emptyList()
    )