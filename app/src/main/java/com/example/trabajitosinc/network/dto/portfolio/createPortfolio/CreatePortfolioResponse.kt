package com.example.trabajitosinc.network.dto.portfolio.createPortfolio
import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewResponse

data class CreatePortfolioResponse (
    val _id: String,
    val title: String,
    val description: String,
    val user: String,
    val category: String,
    val images: List<String>,
    val reviews: List<ReviewResponse> = emptyList()
)