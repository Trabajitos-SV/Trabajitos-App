package com.example.trabajitosinc.repository

import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioRequest
import com.example.trabajitosinc.network.service.PortfolioService
import retrofit2.HttpException
import java.io.IOException

class PortfolioCRepository(private val api: PortfolioService) {

    suspend fun createPortfolio(title: String, description: String, images: Array<String>, category: String ): ApiResponse<String>{
        try {
            val response = api.createPortfolioR(CreatePortfolioRequest(title, description, images, category))
            return ApiResponse.Success(response.message)
        }catch (e: HttpException){
            if (e.code() == 400){
                return ApiResponse.ErrorWithMessage("Check email or password")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }
}