package com.example.trabajitosinc.network.retrofit

import android.service.carrier.CarrierIdentifier
import com.example.trabajitosinc.network.service.AuthService
import com.example.trabajitosinc.network.service.PortfolioService
import com.example.trabajitosinc.repository.PortfolioCRepository
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://joseguidos.tech/"

object RetrofitInstance {

    private var token = ""

    fun setToken(token: String) {
        this.token = token
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getClient())
        .build()

    private fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(Interceptor() { chain ->
                val newRequest = chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer ${token}")
                    .build()
                chain.proceed(newRequest)
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            })
            .build()

        return client
    }


    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun getPortfolioService(): PortfolioService {
        return retrofit.create(PortfolioService::class.java)
    }
}