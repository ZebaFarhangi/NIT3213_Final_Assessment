package com.example.androidappdev

import com.example.androidappdev.login.api.LoginRequest
import com.example.androidappdev.login.data.AddObjectRequest
import com.example.androidappdev.login.network.RestfullApiService


class Repository @Inject constructor(private val apiService: RestfullApiService) {
    annotation class Inject

    suspend fun addObject(username: String, password: String) = apiService.addObjectRequest(LoginRequest(username,password))
    suspend fun getDashboardData(keypass: String) = apiService.getDashboardData(keypass)
}