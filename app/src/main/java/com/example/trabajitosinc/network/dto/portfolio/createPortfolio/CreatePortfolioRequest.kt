package com.example.trabajitosinc.network.dto.portfolio.createPortfolio


data class CreatePortfolioRequest (
    val title : String,
    val description : String,
    val images : String,
    val user: List<String>,
    val category: String,
    val reviews: List<reviewRequest> = emptyList()
    )

data class reviewRequest(
    val review: String,
    val qualification: Int,
    val portfolioId: String,
)

