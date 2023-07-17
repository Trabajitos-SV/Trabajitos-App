package com.example.trabajitosinc.network.service

import com.example.trabajitosinc.network.dto.trabajitos.createTrabajito.CreateTrabajitoResponse
import com.example.trabajitosinc.network.dto.trabajitos.findJobs.FindTrabajitosJobsResponse
import com.example.trabajitosinc.network.dto.trabajitos.findJobs.tempJobModel
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.FindTrabajitosRequestsResponse
import com.example.trabajitosinc.network.dto.trabajitos.findRequests.tempRequestModel
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TrabajitosAPI {
    @POST("api/trabajito")
    suspend fun createTrabajito(description: String, dateInit: String, status: String, id_hired: String): CreateTrabajitoResponse

    @GET("api/trabajito/requests")
    suspend fun getMyRequests(): FindTrabajitosRequestsResponse

    @GET("api/trabajito/requests/{identifier}")
    suspend fun getMyRequestById(@Path("identifier") identifier: String): tempRequestModel

    @GET("api/trabajito/jobs")
    suspend fun getMyJobs(): FindTrabajitosJobsResponse

    @GET("api/trabajito/jobs{identifier}")
    suspend fun getMyJobById(@Path("identifier") identifier: String): tempJobModel
}