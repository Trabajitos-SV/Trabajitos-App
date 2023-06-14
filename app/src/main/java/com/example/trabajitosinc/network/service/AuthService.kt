package com.example.trabajitosinc.network.service

import com.example.trabajitosinc.network.dto.login.LoginRequest
import com.example.trabajitosinc.network.dto.login.LoginResponse
import com.example.trabajitosinc.network.dto.register.RegisterRequest
import com.example.trabajitosinc.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/auth")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse

    @POST("/register")
    suspend fun register(@Body credentials: RegisterRequest): RegisterResponse

}