package com.example.androidappdev.dashboard.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DashboardService {
    @GET("/dashboard/investments")
    suspend fun getDashboardData(@Path("investments") keypass: String): Response<DashboardResponse>
}

data class DashboardResponse(val entities: List<Entity>, val entityTotal: Int)
data class Entity(val property1: String, val property2: String, val description: String)