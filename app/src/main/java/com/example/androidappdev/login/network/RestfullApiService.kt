package com.example.androidappdev.login.network

import com.example.androidappdev.login.api.LoginRequest
import com.example.androidappdev.login.data.AddObjectResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RestfullApiService {
    @POST("/ort/auth")
    suspend fun addObject( @Body requestBody: LoginRequest):AddObjectResponse
    fun getDashboardData(keypass: String): Any
    abstract fun addObjectRequest(loginRequest: LoginRequest): RestfullApiService
}