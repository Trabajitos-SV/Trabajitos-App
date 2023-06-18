package com.example.trabajitosinc.network.service

import com.example.trabajitosinc.network.dto.login.LoginRequest
import com.example.trabajitosinc.network.dto.login.LoginResponse
import com.example.trabajitosinc.network.dto.register.RegisterRequest
import com.example.trabajitosinc.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/auth/login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse

    @POST("api/auth/register")
    suspend fun register(@Body credentials: RegisterRequest): RegisterResponse

}