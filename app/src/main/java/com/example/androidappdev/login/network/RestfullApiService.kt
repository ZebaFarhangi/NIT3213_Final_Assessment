package com.example.androidappdev.login.network

import com.example.androidappdev.login.data.DashboardResponse
import com.example.androidappdev.login.data.ApiRequest
import com.example.androidappdev.login.data.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestfullApiService {
    @POST("ort/auth")
    suspend fun addObject( @Body data: ApiRequest ): ApiResponse

    @GET("dashboard/investments")
    suspend fun getDashboard(@Path("investments") keypass: String): Response<DashboardResponse>
}