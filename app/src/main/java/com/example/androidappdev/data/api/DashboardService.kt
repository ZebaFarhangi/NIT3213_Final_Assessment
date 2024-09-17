package com.example.androidappdev.data.api

import com.example.androidappdev.dashboard.DashboardResponse
import com.example.androidappdev.data.model.InvestmentEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface DashboardService {

    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): DashboardResponse
}



