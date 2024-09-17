package com.example.androidappdev.dashboard

import com.example.androidappdev.data.model.InvestmentEntity

data class DashboardResponse(
    val entities: List<DashboardItem>,
    val entityTotal: Int
)