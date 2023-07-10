package com.example.trabajitosinc.network.service

import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioRequest
import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioResponse
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.FindPortfolioByCategoryIdRequest
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.FindPortfolioByCategoryIdResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PortfolioService {

    @POST("api/portfolio")
    suspend fun createPortfolioR(@Body credentials: CreatePortfolioRequest): CreatePortfolioResponse

    @GET("api/portfolio/byCategory/{identifier}")
    suspend fun findPortfolioByCategoryIdR(@Body credentials: FindPortfolioByCategoryIdRequest): FindPortfolioByCategoryIdResponse

    @GET("api/portfolio/byCategory/{identifier}")
    suspend fun findPortfolioCatTEST(@Path("identifier") identifier: String): FindPortfolioByCategoryIdResponse


}

