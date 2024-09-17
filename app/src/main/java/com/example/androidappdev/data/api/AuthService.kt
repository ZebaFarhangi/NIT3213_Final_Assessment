package com.example.androidappdev.data.api

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/ort/auth")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse
}

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val keypass: String
)
