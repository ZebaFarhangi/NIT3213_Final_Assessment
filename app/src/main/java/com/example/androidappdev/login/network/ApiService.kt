package com.example.androidappdev.login.network

import com.example.androidappdev.login.data.DashboardResponse
import com.example.androidappdev.login.data.LoginRequest
import com.example.androidappdev.login.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("ort/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("dashboard/investments")
    suspend fun getDashboard(@Path("investments") keypass: String): Response<DashboardResponse>
}