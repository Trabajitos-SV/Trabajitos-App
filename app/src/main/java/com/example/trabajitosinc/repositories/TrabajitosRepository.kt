package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.network.dto.trabajitos.findJobs.FindTrabajitosJobsResponse
import com.example.trabajitosinc.network.dto.trabajitos.findJobs.tempJobModel
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.FindTrabajitosRequestsResponse
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel
import com.example.trabajitosinc.network.dto.trabajitos.startTrabajito.StartTrabajitoModel
import com.example.trabajitosinc.network.service.TrabajitosAPI
import retrofit2.HttpException
import java.io.IOException
import java.util.Date

class TrabajitosRepository (private val api: TrabajitosAPI) {
    //Get all requests
    suspend fun getMyRequests(): ApiResponse<FindTrabajitosRequestsResponse> {
        try {
            val response = api.getMyRequests()
            return ApiResponse.Success(response)
        } catch(e: HttpException){
            if (e.code() == 404){
                return ApiResponse.ErrorWithMessage("Requests not found")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }

    //Get a specific request
    suspend fun getMyRequestById(identifier: String): ApiResponse<tempRequestModel> {
        try {
            val response = api.getMyRequestById(identifier)
            return ApiResponse.Success(response)
        }catch (e: HttpException){
            if (e.code() == 404){
                return ApiResponse.ErrorWithMessage("Trabajito not found")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }

    //Get all jobs
    suspend fun getMyJobs(): ApiResponse<FindTrabajitosJobsResponse> {
        try {
            val response = api.getMyJobs()
            return ApiResponse.Success(response)
        } catch(e: HttpException){
            if (e.code() == 404){
                return ApiResponse.ErrorWithMessage("Jobs not found")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }

    suspend fun getMyJobById(identifier: String): ApiResponse<tempJobModel> {
        try {
            val response = api.getMyJobById(identifier)
            return ApiResponse.Success(response)
        }catch (e: HttpException){
            if (e.code() == 404){
                return ApiResponse.ErrorWithMessage("Trabajito not found")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }

    suspend fun startTrabajito(id: String, dateFinish: Date, status: String): ApiResponse<StartTrabajitoModel> {
        try {
            val response = api.startTrabajito(id, dateFinish, status)
            return ApiResponse.Success(response)
        } catch(e: HttpException){
            if (e.code() == 404){
                return ApiResponse.ErrorWithMessage("Trabajito not found")
            }
            return ApiResponse.Error(e)
        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }
}