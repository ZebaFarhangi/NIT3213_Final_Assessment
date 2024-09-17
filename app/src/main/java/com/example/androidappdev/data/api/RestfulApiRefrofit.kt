package com.example.androidappdev.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
// Define the base URL for your API
private const val BASE_URL = "https://vu-nit3213-api.onrender.com"

class RestfulApiRetrofit {

    // Set up logging for network requests
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Build OkHttpClient to include logging
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    // Build Moshi for JSON serialization/deserialization
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Build Retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    // Create API services from the Retrofit instance
    val authService: AuthService = retrofit.create(AuthService::class.java)
    val dashboardService: DashboardService = retrofit.create(DashboardService::class.java)
}
