package com.example.androidappdev.dashboard

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DashboardItem(
    val assetType: String,
    val ticker: String,
    val currentPrice: Double,
    val dividendYield: Double,
    val description: String
) : Parcelable