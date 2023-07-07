package com.example.trabajitosinc.network.dto.portfolio.createPortfolio


data class CreatePortfolioRequest(
    val title: String,
    val description: String,
    val images: Array<String>,
    val category: String
)


