package com.example.trabajitosinc.repository

import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.login.LoginRequest
import com.example.trabajitosinc.network.dto.register.RegisterRequest
import com.example.trabajitosinc.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {

    suspend fun login(email: String, password: String): ApiResponse<String>{
        try {
            val response = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.token)
        }catch (e: HttpException){
            if (e.code() == 400){
                return ApiResponse.ErrorWithMessage("Invalid email or password")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }

    suspend fun register(name: String ,email: String, phone : String, password: String): ApiResponse<String>{
        try {
            val response = api.register(RegisterRequest(name, email, phone, password))
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