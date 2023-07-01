package com.example.trabajitosinc.network.dto.portfolio.createPortfolio

data class CreatePortfolioResponse (
    val _id: String,
    val title: String,
    val description: String,
    val user: String,
    val category: String,
    val images: List<String>,
    val reviews: List<reviewResponse> = emptyList()
)

data class reviewResponse(
    val review: String,
    val qualification: Int,
    val portfolioId: String,
)