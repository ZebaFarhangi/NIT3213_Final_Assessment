package com.example.androidappdev.data.model


import com.squareup.moshi.Json

data class InvestmentEntity(
    @Json(name = "assetType")
    val assetType: String,

    @Json(name = "ticker")
    val ticker: String,

    @Json(name = "currentPrice")
    val currentPrice: Double,

    @Json(name = "dividendYield")
    val dividendYield: Double,

    @Json(name = "description")
    val description: String
)
