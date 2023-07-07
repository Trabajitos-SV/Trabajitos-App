package com.example.trabajitosinc.network.service

import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioRequest
import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PortfolioService {

    @POST("api/portfolio")
    suspend fun createPortfolioR(@Body credentials: CreatePortfolioRequest): CreatePortfolioResponse

}