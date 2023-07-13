package com.example.trabajitosinc.repository

import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.portfolio.createPortfolio.CreatePortfolioRequest
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.FindPortfolioByCategoryIdRequest
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.FindPortfolioByCategoryIdResponse
import com.example.trabajitosinc.network.service.PortfolioService
import retrofit2.HttpException
import java.io.IOException

class PortfolioCRepository(private val api: PortfolioService) {

    //Create Portfolio
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

    suspend fun fndPortfolioByCategoryId(idCategory: String, page: Int): ApiResponse<FindPortfolioByCategoryIdResponse>{
        try {
            val response = api.findPortfolioCatTEST(idCategory, page)
            return ApiResponse.Success(response)
        }catch (e: HttpException){
            if (e.code() == 400){
                return ApiResponse.ErrorWithMessage("The id Category is wrong")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }
}