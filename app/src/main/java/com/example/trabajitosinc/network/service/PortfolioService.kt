package com.example.trabajitosinc.network.service

import com.example.trabajitosinc.network.dto.portfolio.PortfolioResponse
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface PortfolioService {

    @GET("portfolio/myPortfolio")
    suspend fun findMyPortfolio(): List<PortfolioResponse>

    @GET("portfolio")
    suspend fun findAllPortfolio(): List<PortfolioResponse>

    @POST("portfolio")
    suspend fun createPortfolio(): PortfolioResponse

    @PATCH("portfolio/updateMyPortfolio/:id")
    suspend fun updateMyPortfolio(): PortfolioResponse


}