package com.example.trabajitosinc.network.retrofit

import com.example.trabajitosinc.network.service.AuthService
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://retrofit.up.railway.app/"
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

}