package com.example.trabajitosinc.network.dto.portfolio.Review

data class ReviewRequest (
    val review: String,
    val portfolioId: String,
    val qualification: Int
    )