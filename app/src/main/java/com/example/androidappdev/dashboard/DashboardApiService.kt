package com.example.androidappdev.dashboard

import retrofit2.http.GET
import retrofit2.http.Path

interface DashboardApiService {
    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): DashboardResponse
}

data class DashboardResponse(val entities: List<DashboardItem>)
