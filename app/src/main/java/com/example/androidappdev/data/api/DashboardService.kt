package com.example.androidappdev.data.api

import com.example.androidappdev.data.model.InvestmentEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface DashboardService {
    @GET("/dashboard/investments")
    suspend fun getDashboardData(@Header("keypass") keypass: String): DashboardResponse
}

data class DashboardResponse(
    val entities: List<InvestmentEntity>
)
