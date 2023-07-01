package com.example.trabajitosinc.network.dto.portfolio.Reviews

data class ReviewRequest (
    val review: String,
    val qualification: Int,
    val portfolioId: String
    )