package com.example.androidappdev.login

import com.example.androidappdev.data.ApiRequest
import com.example.androidappdev.login.network.RestfullApiService

class Repository @Inject constructor(private val apiService: RestfullApiService) {
    annotation class Inject

    suspend fun addObject(username: String, password: String) = apiService.addObject(ApiRequest(username, password))
    suspend fun getDashboard(keypass: String) = apiService.getDashboard(keypass)
}