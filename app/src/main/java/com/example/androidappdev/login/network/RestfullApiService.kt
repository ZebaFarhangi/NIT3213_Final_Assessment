package com.example.androidappdev.login.network

import com.example.androidappdev.login.data.AddObjectRequest
import com.example.androidappdev.login.data.AddObjectResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RestfullApiService {
    @POST("/ort/auth")
    suspend fun addObject( @Body requestBody: AddObjectRequest):AddObjectResponse
}