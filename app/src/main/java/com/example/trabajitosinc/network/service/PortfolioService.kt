package com.example.trabajitosinc.network.service
import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioResponse
import com.example.trabajitosinc.network.dto.portfolio.findAllPortfolios.FindAllPortfolioResponse
import com.example.trabajitosinc.network.dto.portfolio.findMyPortfolio.FindMyPortfolioResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface PortfolioService {

    @GET("portfolio/myPortfolio")
    suspend fun findMyPortfolio(): FindMyPortfolioResponse

    @GET("portfolio")
    suspend fun findAllPortfolio(): FindAllPortfolioResponse

    @POST("portfolio")
    suspend fun createPortfolio(): CreatePortfolioResponse



}