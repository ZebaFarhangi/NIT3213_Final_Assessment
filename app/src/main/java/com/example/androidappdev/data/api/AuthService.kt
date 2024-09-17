package com.example.androidappdev.data.api

import com.example.androidappdev.login.LoginRequest
import com.example.androidappdev.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/ort/auth")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse
}




