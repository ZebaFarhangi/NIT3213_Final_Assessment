package com.example.androidappdev.dashboard.data

import com.squareup.moshi.Json

data class DashboardResponse(
    @Json val entities: List<Entity>,  // List of entities
    @Json val entityTotal: Int,        // Total number of entities

)
data class Entity(
    @Json(name = "assetType")val assetType: String,
    @Json(name = "ticker")val ticker: String,
    @Json(name = "currentPrice")val currentPrice: Double,
    @Json(name = "dividendYield")val dividendYield: Double,
    @Json(name = "description")val description: String,

)