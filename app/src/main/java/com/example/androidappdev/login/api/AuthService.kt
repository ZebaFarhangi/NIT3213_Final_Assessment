package com.example.androidappdev.login.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/ort/auth")
    suspend fun login(@Body credentials: LoginRequest): Response<LoginResponse>
}

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val keypass: String)