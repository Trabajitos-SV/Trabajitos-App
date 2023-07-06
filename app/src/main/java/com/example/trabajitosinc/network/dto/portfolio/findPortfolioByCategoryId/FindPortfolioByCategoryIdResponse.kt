package com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId

import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewResponse

data class FindPortfolioByCategoryIdResponse (
    val _id: String,
    val title: String,
    val description: String,
    val user: String,
    val images: List<String>,
    val reviews: List<ReviewResponse> = emptyList()

)