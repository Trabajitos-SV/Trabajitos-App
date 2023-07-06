package com.example.trabajitosinc.network.dto.portfolio.createPortfolio

import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewRequest


data class CreatePortfolioRequest (
    val title : String,
    val description : String,
    val images : String,
    val category: String
    )


