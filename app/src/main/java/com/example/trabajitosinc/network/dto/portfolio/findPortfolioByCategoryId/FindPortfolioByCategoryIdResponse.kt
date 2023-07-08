package com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId

import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewResponse
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst

data class FindPortfolioByCategoryIdResponse (
    val docs: List<FindPortfolioByCategoryIdLitst>,
    val totalDocs: Int,
    val limit: Int,
    val totalPages: Int,
    val page: Int,
    val pagingCounter: Int,
    val hasPrevPage: Boolean,
    val hasNextPage: Boolean,
    val prevPage: Int,
    val nextPage: Int,
    )