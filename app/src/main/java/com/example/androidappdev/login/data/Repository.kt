package com.example.androidappdev.login.data

import com.example.androidappdev.login.network.ApiService

class Repository @Inject constructor(private val apiService: ApiService) {
    annotation class Inject

    suspend fun login(username: String, password: String) = apiService.login(LoginRequest(username, password))
    suspend fun getDashboard(keypass: String) = apiService.getDashboard(keypass)
}