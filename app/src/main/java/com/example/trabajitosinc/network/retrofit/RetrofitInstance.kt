package com.example.trabajitosinc.network.retrofit

import com.example.trabajitosinc.network.service.AuthService
import com.example.trabajitosinc.repository.PortfolioCRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://joseguidos.tech/"
object RetrofitInstance {

    private var token = ""

    fun setToken(token: String){
        this.token = token
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun getPortfolioService(): PortfolioCRepository {
        return retrofit.create(PortfolioCRepository::class.java)
    }

}